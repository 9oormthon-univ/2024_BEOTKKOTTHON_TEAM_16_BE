package org.univ.dangol.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.univ.dangol.dto.Position;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Slf4j
@RestController
@AllArgsConstructor
public class OpenApiController {
    private final WebClient webClient;
    @GetMapping("/publicTraditional")
    public Mono<String> getMarketDateByUserPosition(@RequestBody Position position){
        BigDecimal latitude = position.getLatitude();
        BigDecimal longitude = position.getLongitude();
        String ans = latitude.toString()+longitude.toString();

        return "test";
    }
}
