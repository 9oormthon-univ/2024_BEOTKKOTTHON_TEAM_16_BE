package org.univ.dangol.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.dto.BadgePosition;
import org.univ.dangol.dto.ShopDTO;
import org.univ.dangol.dto.ShopScreen;
import org.univ.dangol.entity.Item;
import org.univ.dangol.service.ItemService;
import org.univ.dangol.service.ShopService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@AllArgsConstructor
public class ShopController {
    private final ShopService shopService;
    private final ItemService itemService;
    @GetMapping("users/{userId}/shopScreen")
    public ShopScreen shopScreen(@PathVariable("userId") Long userId){
        List<ShopDTO> shopDTOList = shopService.getShopDTOs(userId);
        Optional<Item> nextItem = itemService.getNextItem(userId);

        //location Item 삭제, 모든 Item 에는 위치가 있음
        BadgePosition badgePosition = nextItem.map(item -> {
            Double longitude = Optional.ofNullable(item.getLongitude()).map(BigDecimal::doubleValue).orElse(null);
            Double latitude = Optional.ofNullable(item.getLatitude()).map(BigDecimal::doubleValue).orElse(null);
            return BadgePosition.builder()
                    .longitude(longitude)
                    .latitude(latitude)
                    .build();
        }).orElse(null); // nextItem이 없거나 longitude/latitude가 null인 경우 null을 반환

        return ShopScreen.builder()
                 .shops(shopDTOList)
                 .badgePosition(badgePosition)
                 .build();
    }
}
