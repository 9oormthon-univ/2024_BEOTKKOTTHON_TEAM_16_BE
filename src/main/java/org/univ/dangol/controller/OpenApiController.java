package org.univ.dangol.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.dto.Position;

import org.univ.dangol.dto.apiDto.Feature;
import org.univ.dangol.entity.Market;
import org.univ.dangol.service.OpenApiService;


import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class OpenApiController {
    private final OpenApiService openApiService;
    @PostMapping("/publicTraditional")
    public List<Market> getMarketListByUserPosition(@RequestBody Position position){
        BigDecimal latitude = position.getLatitude();
        BigDecimal longitude = position.getLongitude();

        return openApiService.getMarketListByUserPosition(latitude,longitude,10).block();
    }
}
