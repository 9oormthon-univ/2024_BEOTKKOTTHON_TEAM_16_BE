package org.univ.dangol.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.dto.Position;

import java.math.BigDecimal;

@Slf4j
@RestController
@AllArgsConstructor
public class OpenApiController {
    @PostMapping("/publicTraditional")
    public String getTraditionalShopDateByUserPosition(@RequestBody Position position){
        BigDecimal latitude = position.getLatitude();
        BigDecimal longitude = position.getLongitude();
        String ans = latitude.toString()+longitude.toString();

        return ans;
    }
}
