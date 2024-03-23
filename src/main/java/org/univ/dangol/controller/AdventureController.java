package org.univ.dangol.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.dto.*;
import org.univ.dangol.entity.Grade;
import org.univ.dangol.entity.Item;
import org.univ.dangol.entity.PopupType;
import org.univ.dangol.service.AdventureService;
import org.univ.dangol.service.ItemService;
import org.univ.dangol.service.UserService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AdventureController {
    private final UserService userService;
    private final AdventureService adventureService;
    private final ItemService itemService;
    /**
     * levelUpController
     * 클라이언트에서 레벨업이라고 판단 시, 해당 API에 요청을 시도한다
     *
     * location -> 클라이언트가 판단 및 호출
     * quiz -> quizValidation 완료 후 서버가 판단.
     */
    @PostMapping("users/{userId}/levelUp")
    public LevelUpPopup levelUpController(@PathVariable("userId") Long userId){
        Grade grade = userService.getTopGrade(userId);
         if(adventureService.checkLevelUp(userId)){

             Position position = Position.builder()
                     .latitude(BigDecimal.valueOf(37.3517946947480700))
                     .longitude(BigDecimal.valueOf(127.0714870747828400))
                     .build();

             return LevelUpPopup.builder()
                     .tierImgUrl(grade.getTierImage())
                     .title(grade.getTier() + " Level UP!")
                     .grade(grade.getName())
                     .level(userService.getTopGrade(userId).getId())
                     .characterImgUrl(grade.getCharacterImage())
                     .description(
                             "우와 벌써 트로피를 " + (userService.getTopGrade(userId).getId() - 1) + "개나 획득하셨군요!?\n" +
                                     grade.getName() + "이 되신 것을 축하드립니다!"
                     )  // 뱃지 갯수 넣기
                     .position(position)
                     .build();
         }else{
             return null;
         }
    }
    /**
     * touchTriggerController
     * 마커와의 터치 발생 시, 발생하는 컨트롤러
     */
    @PostMapping("users/{userId}/touch")
    public TouchResponse touchTriggerController(@PathVariable("userId") Long id){
        Item item = adventureService.touchTrigger(id);
        Item nextItem = null;

        if(item.getId() != 9)
        {
            nextItem = itemService.findByItemIdNextItem(item);
        }
        else{
            // 임시 방편, 추후 수정해야 함
            nextItem = Item.builder()
                    .latitude(BigDecimal.valueOf(999.999))
                    .longitude(BigDecimal.valueOf(999.999))
                    .build();
        }
        log.warn("nextItem id :" + nextItem.getId());
        log.warn("nextItem type : " + nextItem.getType());

        QuizPopup quizPopup = null;
        BadgePopup badgePopup = BadgePopup.builder()
                .title(item.getName())
                .description(item.getPopupDescription())
                .imgUrl(item.getImage())
                .build();
        Position position = Position.builder()
                .latitude(nextItem.getLatitude())
                .longitude(nextItem.getLongitude())
                .build();
        if(item.getType() == PopupType.Quiz){
            QuizWarningPopup quizWarningPopup = QuizWarningPopup.builder()
                    .title(item.getQuizTitle())
                    .name(item.getQuizWarningImageText())
                    .image(item.getQuizWarningImage())
                    .confirm(item.getQuizConfirmText())
                    .build();

            QuizQuestionPopup quizQuestionPopup = QuizQuestionPopup.builder()
                    .title(item.getQuizTitle())
                    .question(item.getQuizQuestion())
                    .positive(item.getQuizPositive())
                    .negative(item.getQuizNegative())
                    .build();

            quizPopup = QuizPopup.builder()
                    .quizWarningPopup(quizWarningPopup)
                    .quizQuestionPopup(quizQuestionPopup)
                    .build();
        }

        return TouchResponse.builder()
                .popupType(item.getType())
                .position(position)
                .itemId(item.getId())
                .badgePopup(badgePopup)
                .quizPopup(quizPopup)
                .build();
    }

    @PostMapping("users/{user_id}/answer/{answer}")
    public Map<String, Boolean> getQuizAnswer(
            @PathVariable("user_id") Long id,
            @PathVariable("answer") String answer
    ){
        Map<String, Boolean> response = new HashMap<>();
        if(adventureService.quizValidation(answer, id))
        {
            if(adventureService.checkLevelUp(id)){
                response.put("isCollect", true);
                response.put("isLevelUp", true);
            }else{
                response.put("isCollect", true);
                response.put("isLevelUp", false);
            }
        }
        else {
            response.put("isCollect", false);
            response.put("isLevelUp", false);
        }
        return response;
    }
}
