package org.univ.dangol.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.dto.*;
import org.univ.dangol.entity.ItemStatus;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TempProfileScreenController {
    @GetMapping("users/{userId}/profile")
    public ResponseEntity<ProfileScreen> profileScreen(@PathVariable("userId")int userId){
        // TO DO CHANGE REGION
        List<BookRow> bookRows = new ArrayList<>();
        Badge badge1 = Badge.builder()
                .id(1L).name("탐험가").acquisitionMethod(ItemStatus.APP).acquiredAt(LocalDateTime.now()).description("첫 번째 퀘스트 보상 탐험가 배지")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Hat.png")
                .build();
        Badge badge2 = Badge.builder()
                .id(2L).name("단골 손님").acquisitionMethod(ItemStatus.APP).acquiredAt(LocalDateTime.now()).description("두 번째 퀘스트 보상 단골 손님 배지")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Bag.png")
                .build();
        Badge badge3 = Badge.builder()
                .id(3L).name("탐색의 시작").acquisitionMethod(ItemStatus.APP).acquiredAt(LocalDateTime.now()).description("세 번째 퀘스트 보상 탐색의 시작 배지")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Flashlight.png")
                .build();
        Badge badge4 = Badge.builder()
                .id(4L).name("푸르른 녹두").acquisitionMethod(ItemStatus.Quiz).acquiredAt(null).description("네 번째 퀘스트 보상 푸르른 녹두 배지")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/WheatShadow.png")
                .build();
        Badge badge5 = Badge.builder()
                .id(5L).name("달다구리 꿀").acquisitionMethod(ItemStatus.Location).acquiredAt(null).description("다섯 번째 퀘스트 보상 달다구리 꿀 배지")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/HoneypotShadow.png")
                .build();
        Badge badge6 = Badge.builder()
                .id(6L).name("말랑말랑 꿀떡").acquisitionMethod(ItemStatus.Quiz).acquiredAt(null).description("여섯 번째 퀘스트 보상 말랑말랑 꿀떡 배지")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/HoneyricecakeShadow.png")
                .build();
        Badge badge7 = Badge.builder()
                .id(7L).name("복슬복슬 복숭아").acquisitionMethod(ItemStatus.Quiz).acquiredAt(null).description("일곱 번째 퀘스트 보상 복슬복슬 복숭아 배지")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/PeachShadow.pngg")
                .build();
        Badge badge8 = Badge.builder()
                .id(8L).name("바삭바삭 녹두전").acquisitionMethod(ItemStatus.Location).acquiredAt(null).description("여덟 번째 퀘스트 보상 바삭바삭 녹두전 배지")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/JeonShadow.png")
                .build();
        Badge badge9 = Badge.builder()
                .id(9L).name("신선한 과일 바구니").acquisitionMethod(ItemStatus.Location).acquiredAt(null).description("아홉 번째 퀘스트 보상 신선한 과일 바구니 배지")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/FruitbasketShadow.png")
                .build();
        Reward reward1 = Reward.builder().id(1).isAcquired(false).isUsed(false).imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/TrophyShadow.png").build();
        Reward reward2 = Reward.builder().id(2).isAcquired(false).isUsed(false).imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/TrophyShadow.png").build();
        Reward reward3 = Reward.builder().id(3).isAcquired(false).isUsed(false).imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/TrophyShadow.png").build();
        List<Badge> badges1 = new ArrayList<>(); badges1.add(badge1); badges1.add(badge2); badges1.add(badge3);
        List<Badge> badges2 = new ArrayList<>(); badges2.add(badge4); badges2.add(badge5); badges2.add(badge6);
        List<Badge> badges3 = new ArrayList<>(); badges3.add(badge7); badges3.add(badge8); badges3.add(badge9);
        bookRows.add(BookRow.builder().badges(badges1).reward(reward1).build());
        bookRows.add(BookRow.builder().badges(badges2).reward(reward2).build());
        bookRows.add(BookRow.builder().badges(badges3).reward(reward3).build());
        ProfileScreen dto = ProfileScreen.builder()
                .nickname("guest")
                .gradeDescription("조금만 더 시장을 탐험하면,\n장터 보물사냥꾼이 될 수 있어요!")
                .characterName("장터 탐험가")
                .currentImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/siverGrade.png")
                .nextImage("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/goldGradeShadow.png")
                .bookRows(bookRows)
                .build();
        // END REGION

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok()
                .headers(headers)
                .body(dto);
    }
}
