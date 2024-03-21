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
        List<String> taglist = new ArrayList<>(); taglist.add("떡볶이"); taglist.add("어묵"); taglist.add("순대");
        ShopDTO shopDTO = ShopDTO.builder()
                .id(1)
                .name("마천골")
                .address("서울 송파구 마천로45길 44")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/machungol.png")
                .category("분식집")
                .tags(taglist)
                .latitude(37.49934116173424000000)
                .longitude(127.15214585905004000000)
                .build();
        shopDTOList.add(shopDTO);
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
