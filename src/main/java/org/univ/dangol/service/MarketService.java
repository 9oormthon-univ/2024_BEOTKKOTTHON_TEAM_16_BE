package org.univ.dangol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.dto.MarketScreen;
import org.univ.dangol.dto.RecommendMarket;
import org.univ.dangol.entity.Market;
import org.univ.dangol.repository.MarketRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MarketService {
    private final MarketRepository marketRepository;

    private static RecommendMarket toRecommendMarket(Market market) {
        return RecommendMarket.builder()
                .id(market.getId())
                .description(market.getDescription())
                .imgUrl(market.getImage())
                .latitude(market.getLatitude() != null ? market.getLatitude().doubleValue() : 0.0)
                .longitude(market.getLongitude() != null ? market.getLongitude().doubleValue() : 0.0)
                .build();
    }

    public MarketScreen marketScreen() {
        List<RecommendMarket> recommendMarketList = marketRepository.findAll().stream()
                .map(MarketService::toRecommendMarket)
                .limit(3) // 스트림의 결과를 처음 3개로 제한
                .collect(Collectors.toList());

        return MarketScreen.builder().markets(recommendMarketList).build();
    }
}
