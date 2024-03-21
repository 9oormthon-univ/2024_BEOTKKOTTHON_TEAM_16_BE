package org.univ.dangol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.dto.ShopDTO;
import org.univ.dangol.entity.Shop;
import org.univ.dangol.repository.ShopRepository;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    public static ShopDTO toShopDTO(Shop shop) {
        ShopDTO shopDTO = ShopDTO.builder()
                .id(shop.getId())
                .name(shop.getName())
                .address(shop.getAddress())
                .imgUrl(shop.getImage())
                .category(shop.getCategory())
                .tags(Arrays.asList("Tag1", "Tag2"))
                .latitude(shop.getLatitude().doubleValue())
                .longitude(shop.getLongitude().doubleValue())
                .build();
        return shopDTO;
    }
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }
}
