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
             return LevelUpPopup.builder()
                     .tierImgUrl("으아 넣어야 한다")
                     .title(grade.getTier() + "Level UP!")
                     .grade(grade.getName())
                     .characterImgUrl(grade.getCharacterImage())
                     .description(
                             "우와 벌써 배지를" + "몇개" + "나 획득하셨군요 ?!\n" +
                                     grade.getName() + "이 되신 것을 축하드립니다!"
                     )  // 뱃지 갯수 넣기
                     //.latitude(11.111f) // 시장 상인회 위도 넣기
                     //.longitude(11.111f) // 시장 상인회 경도 넣기
                     .build();
         }else{
            //null
         }
    }

    /**
     * touchTriggerController
     * 마커와의 터치 발생 시, 발생하는 컨트롤러
     */

    @PostMapping("users/{userId}/touch")
    public TouchResponse touchTriggerController(@PathVariable("userId") Long id){

        Item item = adventureService.touchTrigger(id);
        Item nextItem = itemService.findByItemIdNextItem(item);

        QuizPopup quizPopup = null;
        BadgePopup badgePopup = BadgePopup.builder()
                .title(item.getName())
                .description(item.getPopupDescription())
                .imgUrl(item.getImage())
                .build();

        BadgePosition badgePosition = BadgePosition.builder()
                .latitude(nextItem.getLatitude())
                .longitude(nextItem.getLongitude())
                .build();

        if(item.getType() == PopupType.Quiz){
            QuizWarningPopup quizWarningPopup = QuizWarningPopup.builder()
                    .title(item.getQuizTitle())
                    .name("어흥어흥")
                    .image("어흥이 사진")
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
                .badgePosition(badgePosition)
                .badgePopup(badgePopup)
                .quizPopup(quizPopup)
                .build();
    }

    @PostMapping("users/{user_id}/answer/{answer}")
    public String getQuizAnswer(
            @PathVariable("user_id") Long id,
            @PathVariable("answer") String answer){
        if(adventureService.quizValidation(answer, id))
        {
            return "isCorrect = true";
        }
        else {
            return "isCorrect = false";
        }
    }


}
