package org.univ.dangol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.univ.dangol.dto.apiDto.*;
import org.univ.dangol.entity.Market;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OpenApiService {
    private final WebClient webClient;
    @Value("${api.key}")
    private String apiKey;
    private static final String IMG_URL = "https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/tmpMarketImage.png";
    private <T> String positionFormatting(T latitude, T longitude) {
        return String.format("POINT(%s %s)", longitude, latitude);
    }

    private Mono<List<Feature>> getFeatureByUserPosition(BigDecimal latitude, BigDecimal longitude, int size){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("request","GetFeature")
                        .queryParam("data","LT_P_TRADSIJANG")
                        .queryParam("key",apiKey)
                        .queryParam("crs","EPSG:4326")
                        .queryParam("format","json")
                        .queryParam("errorFormat","json")
                        .queryParam("size",size)
                        .queryParam("geomFilter", positionFormatting(latitude,longitude))
                        .queryParam("buffer",200000)
                        .build())
                .retrieve()
                .bodyToMono(ApiResponseDto.class)
                .map(apiResponseDTO -> apiResponseDTO.getResponse().getResult().getFeatureCollection().getFeatures());
    }

    private Market convertFeatureToMarket(Feature feature) {
        Properties props = feature.getProperties();
        Geometry geometry = feature.getGeometry();
        return Market.builder()
                .name(props.getName())
                .image(IMG_URL)
                .description(props.getCategory()) // 예시로 category를 description으로 사용
                .latitude(new BigDecimal(geometry.getCoordinates().get(1)))
                .longitude(new BigDecimal(geometry.getCoordinates().get(0)))
                .address(props.getAdr_road())
                .build();
    }

    public Mono<List<Market>> getMarketListByUserPosition(BigDecimal latitude, BigDecimal longitude, int size) {
        return getFeatureByUserPosition(latitude, longitude,size)
                .map(features -> features.stream()
                        .map(this::convertFeatureToMarket)
                        .collect(Collectors.toList()));
    }
}

