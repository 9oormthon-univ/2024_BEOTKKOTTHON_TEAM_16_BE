package org.univ.dangol.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.dto.MarketScreen;
import org.univ.dangol.service.MarketService;

@Slf4j
@RestController
@AllArgsConstructor
public class TempMarketScreenController {
    private final MarketService marketService;
    @GetMapping("users/{userId}/markets/recommend")
    public MarketScreen recommendMarkets(@PathVariable("userId") Long userId){
        // TO DO CHANGE REGION
        return marketService.marketScreen();
    }
}
