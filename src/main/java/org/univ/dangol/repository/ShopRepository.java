package org.univ.dangol.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.univ.dangol.entity.Shop;
import org.univ.dangol.entity.User;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
