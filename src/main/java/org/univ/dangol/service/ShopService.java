package org.univ.dangol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.dto.ShopDTO;
import org.univ.dangol.entity.Shop;
import org.univ.dangol.repository.ShopRepository;
import org.univ.dangol.repository.UserItemRepository;
import org.univ.dangol.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
    public static ShopDTO toShopDTO(Shop shop) {
        return ShopDTO.builder()
                .id(shop.getId())
                .name(shop.getName())
                .address(shop.getAddress())
                .imgUrl(shop.getImage())
                .category(shop.getCategory())
                .tags(Arrays.asList(shop.getTag().split("-")))
                .latitude(shop.getLatitude().doubleValue())
                .longitude(shop.getLongitude().doubleValue())
                .build();
    }
    // 모든 Shop정보를 ShopDTO로 바꾸어 전달
    public List<ShopDTO> getShopDTOs(){
        List<Shop> shopList = getAllShops();
        List<ShopDTO> ans = new ArrayList<>();
        for (Shop shop : shopList) {
            ans.add(toShopDTO(shop));
        }
        return ans;
    }
    @Transactional(readOnly = true)
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }
}
