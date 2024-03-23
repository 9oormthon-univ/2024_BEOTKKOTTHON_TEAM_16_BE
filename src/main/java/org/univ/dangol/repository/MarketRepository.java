package org.univ.dangol.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.univ.dangol.entity.Market;
import org.univ.dangol.entity.Shop;

import java.util.Optional;

public interface MarketRepository extends JpaRepository<Market, Long> {

    @NonNull Optional<Market> findById(@NonNull Long id);
    Optional<Market> findByName(String name);

}
