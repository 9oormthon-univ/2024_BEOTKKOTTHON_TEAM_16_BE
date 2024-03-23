package org.univ.dangol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.univ.dangol.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
