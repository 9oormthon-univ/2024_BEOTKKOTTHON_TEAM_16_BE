package org.univ.dangol.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.dto.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TempLevelUpPopupController {
    @GetMapping("users/{userId}/level/{levelId}")
    public ResponseEntity<LevelUpPopup> levelUpPopup() {
        // TO DO CHANGE REGION
        LevelUpIntroducePopup levelUpIntroducePopup = LevelUpIntroducePopup.builder()
                .title("Sliver Level UP !")
                .grade("장터 보물 사냥꾼")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/siverGrade.png")
                .tierImgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/sliverTierIcon.png")
                .description("우와, 벌써 배지를 3개나 획득하셨군요 ?!\n장터 보물 사냥꾼이 되신 것을 축하드립니다!")
                .confirm("이어서 탐색하기")
                .build();
        RewardPopup rewardPopup = RewardPopup.builder()
                .title("축하드립니다🥳")
                .description("꺄 트로피네요!\n퀘스트 달성 완료를 축하드립니다.\n상인회로 이동해서 상품을 받아보세요✨")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Trophy.png")
                .positive("시장상인회 이동하기")
                .negative("다음에 받기")
                .latitude(37.49839045691535)
                .longitude(127.15138129910228)
                .id(1)
                .build();
        LevelUpPopup dto = LevelUpPopup.builder()
                .levelUpIntroducePopup(levelUpIntroducePopup)
                .rewardPopup(rewardPopup)
                .build();
        // END REGION

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok()
                .headers(headers)
                .body(dto);
    }
}
