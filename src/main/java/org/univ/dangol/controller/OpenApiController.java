package org.univ.dangol.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.univ.dangol.dto.Position;
import org.univ.dangol.dto.apiDto.Response;
import org.univ.dangol.service.OpenApiService;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Slf4j
@RestController
@AllArgsConstructor
public class OpenApiController {
    private final OpenApiService openApiService;
    @PostMapping("/publicTraditional")
    public Mono<Response> getMarketListByUserPosition(@RequestBody Position position){
        BigDecimal latitude = position.getLatitude();
        BigDecimal longitude = position.getLongitude();
        String ans = latitude.toString()+longitude.toString();

        return openApiService.getMarketListByUserPosition(latitude,longitude);
    }
}
