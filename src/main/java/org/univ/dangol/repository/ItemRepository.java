package org.univ.dangol.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.univ.dangol.entity.Item;
import org.univ.dangol.entity.Shop;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
