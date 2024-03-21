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
