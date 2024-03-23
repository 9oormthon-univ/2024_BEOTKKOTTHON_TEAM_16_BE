package org.univ.dangol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.univ.dangol.dto.apiDto.Response;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OpenApiService {
    private final WebClient webClient;
    public <T> String positionFormatting(T latitude, T longitude){
        return "POINT(" + longitude+" "+ latitude+")";
    }
    public Mono<Response> getMarketListByUserPosition(BigDecimal latitude, BigDecimal longitude){
        Mono<Response> ans = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("request","GetFeature")
                        .queryParam("data","LT_P_TRADSIJANG")
                        .queryParam("key","C612945A-406F-3466-9087-E652D58BBE04")
                        .queryParam("crs","EPSG:4326")
                        .queryParam("errorFormat","json")
                        .queryParam("size","10")
                        .queryParam("geomFilter", positionFormatting(latitude,longitude))
                        .queryParam("buffer",20000)
                        .build())
                .retrieve()
                .bodyToMono(Response.class);
        System.out.println(ans.toString());
        return ans;
    }

}
