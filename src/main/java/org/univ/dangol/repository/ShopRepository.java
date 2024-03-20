package org.univ.dangol.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.univ.dangol.entity.Shop;
import org.univ.dangol.entity.User;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    @NonNull Optional<Shop> findById(@NonNull Long id);
    Optional<Shop> findByName(String name);
    Optional<Shop> findByRegion1DepthAndRegion2DepthAndRegion3Depth(String region1Depth, String region2Depth, String region3Depth);
}
