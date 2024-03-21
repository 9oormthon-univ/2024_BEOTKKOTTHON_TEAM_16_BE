package org.univ.dangol.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.dto.BadgePosition;
import org.univ.dangol.dto.ShopDTO;
import org.univ.dangol.dto.ShopScreen;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TempShopController {
    @GetMapping("users/{userId}/shops")
    public ResponseEntity<ShopScreen> shopScreen(){
        // TO DO CHANGE REGION
        List<ShopDTO> shopDTOList = new ArrayList<>();
        List<String> taglist1 = new ArrayList<>(); taglist1.add("떡볶이"); taglist1.add("어묵"); taglist1.add("순대");
        List<String> taglist2 = new ArrayList<>(); taglist2.add("김치"); taglist2.add("애호박");
        List<String> taglist3 = new ArrayList<>(); taglist3.add("닭발"); taglist3.add("닭내장탕");
        ShopDTO shopDTO1 = ShopDTO.builder()
                .id(4)
                .name("마천골")
                .address("서울 송파구 마천로45길 44")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/machungol.png")
                .category("분식집")
                .tags(taglist1)
                .latitude(37.49934116173424000000)
                .longitude(127.15214585905004000000)
                .isBookmarked(false)
                .build();
        ShopDTO shopDTO2 = ShopDTO.builder()
                .id(1)
                .name("맛있는 반찬")
                .address("서울 송파구 마천로45길 26-1")
                .imgUrl("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20161121_3%2F1479723448243BaHQk_JPEG%2F177071594748106_0.jpeg")
                .category("반찬가계")
                .tags(taglist2)
                .latitude(37.49801486051775600000)
                .longitude(127.15093314233705000000)
                .isBookmarked(false)
                .build();
        ShopDTO shopDTO3 = ShopDTO.builder()
                .id(2)
                .name("춘천 닭발")
                .address("서울 송파구 성내천로32길 22")
                .imgUrl("https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20231027_33%2F1698414161584mfp0z_JPEG%2F1000002390.jpg")
                .category("일반 음식점")
                .tags(taglist3)
                .latitude(37.49791542117659000000)
                .longitude(127.15119021370128000000)
                .isBookmarked(false)
                .build();
        shopDTOList.add(shopDTO1); shopDTOList.add(shopDTO2); shopDTOList.add(shopDTO3);
        BadgePosition badgePosition = BadgePosition.builder().build();
        ShopScreen dto = ShopScreen.builder()
                 .shops(shopDTOList)
                 .badgePosition(badgePosition)
                 .build();
        // END REGION

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok()
                .headers(headers)
                .body(dto);
    }
}
