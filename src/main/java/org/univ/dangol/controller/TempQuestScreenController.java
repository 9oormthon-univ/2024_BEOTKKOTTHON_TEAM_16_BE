package org.univ.dangol.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.dto.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TempQuestScreenController {
    @GetMapping("users/{userId}/questScreen/{sequence}")
    public ResponseEntity<QuestScreen> questList(@PathVariable("sequence")int sequence){
        // TO DO CHANGE REGION
        List<Quest> quests = new ArrayList<>();
        Quest quest1 = Quest.builder()
                .id(1)
                .name("탐험가")
                .isAcquired(true)
                .description("탐험을 떠나 볼까요?(디자인 x)")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/Hat.png")
                .build();
        Quest quest2 = Quest.builder()
                .id(2)
                .name("탐색의 시작")
                .isAcquired(false)
                .description("이제는 %B%직접%B% 시장을\n %B%탐험%B%해볼 시간이에요!")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/FlashlightShadow.pngg")
                .build();
        Quest quest3 = Quest.builder()
                .id(3)
                .name("단골 손님")
                .isAcquired(false)
                .description("좋아하는 상점을\n %B%단골%B%로 등록해보세요!")
                .imgUrl("https://groomthonimagebucket.s3.ap-northeast-2.amazonaws.com/BagShadow.png")
                .build();
        quests.add(quest1); quests.add(quest2); quests.add(quest3);
        QuestScreen dto = QuestScreen.builder()
                .quests(quests)
                .sequence(sequence)
                .build();
        // END REGION

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok()
                .headers(headers)
                .body(dto);
    }
}
