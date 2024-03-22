package org.univ.dangol.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.entity.Item;
import org.univ.dangol.service.AdventureService;
import org.univ.dangol.service.ItemService;
import org.univ.dangol.service.UserService;
import org.univ.dangol.dto.ItemDTO;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AdventureController {

    private final UserService userService;
    private final AdventureService adventureService;
    private final ItemService itemService;

    /**
     * touchTriggerController
     * 마커와의 터치 발생 시, 발생하는 컨트롤러
     */

    @PostMapping("users/{userId}/touch")
    public ItemDTO touchTriggerController(@PathVariable("userId") Long id){
        // (추가해야 할 기능) 3개마다 reward 제공
        // (9개 넘을 시 에러 메세지 제공)

        Item item = adventureService.touchTrigger(id);
        Item nextItem = itemService.findByItemIdNextItem(item);


        return ItemDTO.builder()
                .Id(item.getId())
                .type(item.getType())
                .name(item.getName())
                .nextId(nextItem.getId())
                .nextLatitude(nextItem.getLatitude())
                .nextLongitude(nextItem.getLongitude())
                .popupDescription(item.getPopupDescription())
                .profileDescription(item.getProfileDescription())
                .image(item.getImage())
                .latitude(item.getLatitude())
                .longitude(item.getLongitude())
                .quizPositive(item.getQuizPositive())
                .quizNegative(item.getQuizNegative())
                .quizWarningTitle(item.getQuizWarningTitle())
                .quizWarningImage(item.getQuizWarningImage())
                .quizQuestion(item.getQuizQuestion())
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
