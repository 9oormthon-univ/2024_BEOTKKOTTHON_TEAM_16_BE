package org.univ.dangol.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.univ.dangol.dto.ShopDTO;
import org.univ.dangol.entity.Shop;
import org.univ.dangol.entity.User;
import org.univ.dangol.repository.BookMarkRepository;
import org.univ.dangol.repository.ShopRepository;
import org.univ.dangol.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
    private final BookMarkRepository bookMarkRepository;
    private final UserRepository userRepository;

    public ShopDTO toShopDTO(Shop shop, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        boolean isBookMarked = bookMarkRepository.existsByUserAndShop(user, shop);

        return ShopDTO.builder()
                .id(shop.getId())
                .name(shop.getName())
                .address(shop.getAddress())
                .imgUrl(shop.getImage())
                .category(shop.getCategory())
                .tags(Arrays.asList(shop.getTag().split("-")))
                .latitude(shop.getLatitude().doubleValue())
                .longitude(shop.getLongitude().doubleValue())
                .isBookmarked(isBookMarked)
                .build();
    }

    // 모든 Shop정보를 ShopDTO로 바꾸어 전달
    public List<ShopDTO> getShopDTOs(Long userId){
        List<Shop> shopList = getAllShops();
        List<ShopDTO> ans = new ArrayList<>();
        for (Shop shop : shopList) {
            ans.add(toShopDTO(shop, userId));
        }
        return ans;
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }
}
