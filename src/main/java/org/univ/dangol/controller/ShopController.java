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
    public ShopScreen shopScreen(@PathVariable("userId") Long userId) {
        List<ShopDTO> shopDTOList = shopService.getShopDTOs(userId);
        Optional<Item> nextItem = itemService.getNextItem(userId);

        BadgePosition badgePosition = nextItem
                .filter(item -> item.getLatitude() != null && item.getLongitude() != null)
                .map(item -> BadgePosition.builder()
                        .longitude(item.getLongitude())
                        .latitude(item.getLatitude())
                        .build())
                .orElse(null);

        return ShopScreen.builder()
                .shops(shopDTOList)
                .badgePosition(badgePosition)
                .build();
    }
}
