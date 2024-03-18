package org.univ.dangol.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.univ.dangol.entity.Market;
import org.univ.dangol.entity.Shop;

import java.util.Optional;

public interface MarketRepository extends JpaRepository<Market, Long> {

    @NonNull Optional<Market> findById(@NonNull Long id);
    Optional<Market> findByName(String name);
    Optional<Market> findByRegion1DepthAndRegion2DepthAndRegion3Depth(String region1Depth, String region2Depth, String region3Depth);
}
