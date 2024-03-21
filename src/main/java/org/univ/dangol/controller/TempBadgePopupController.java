package org.univ.dangol.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.dto.BadgePopup;

import java.nio.charset.Charset;

@Slf4j
@RestController
public class TempBadgePopupController {
    @GetMapping("users/{userId}/badge/{badgeId}")
    public ResponseEntity<?> badgePopup(@PathVariable("badgeId")int badgeId){
        // TO DO CHANGE REGION
        BadgePopup dto = new BadgePopup();
        switch (badgeId) {
            case 2 -> dto = BadgePopup.builder()
                    .title("탐색의 시작 배지 획득🔥")
                    .description("시장의 %G%첫 탐색의 시작%G%을 축하드립니다!\n탐색의 시작 배지를 획득하셨어요.")
                    .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Flashlight.png")
                    .positive("이어서 탐험하기")
                    .negative("도감 이동하기")
                    .id(3L)
                    .build();
            case 3 -> dto = BadgePopup.builder()
                    .title("단골 배지 획득🔥")
                    .description("%G%단골손님%G%이 되신 것을 축하드립니다!\n단골손님 배지를 획득하셨어요.")
                    .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Bag.png")
                    .positive("이어서 탐험하기")
                    .negative("도감 이동하기")
                    .id(4L)
                    .build();
            default -> {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("잘못된 요청입니다. 유효한 badgeId를 전송해주세요. 시연 단계에서는 2,3만 존재합니다.");
            }
        }
        // END REGION

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok()
                .headers(headers)
                .body(dto);
    }
}
