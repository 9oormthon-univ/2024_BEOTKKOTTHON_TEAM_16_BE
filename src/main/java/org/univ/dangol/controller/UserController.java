package org.univ.dangol.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.univ.dangol.dto.Badge;
import org.univ.dangol.dto.UserLoginDTO;
import org.univ.dangol.dto.UserProflieDTO;
import org.univ.dangol.entity.Grade;
import org.univ.dangol.entity.Item;
import org.univ.dangol.entity.User;
import org.univ.dangol.entity.UserItem;
import org.univ.dangol.repository.UserItemRepository;
import org.univ.dangol.service.ItemService;
import org.univ.dangol.service.UserService;
import org.univ.dangol.test_dto.TEST_QuestScreenDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ItemService itemService;
    // 회원 가입 - POST
    @PostMapping("users/{nickName}")
    public UserLoginDTO join(@PathVariable("nickName") String nickName) {
        Pair<Optional<User>, Optional<Grade>> userAndGrade = userService.join(nickName);

        User user = userAndGrade.getFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Grade grade = userAndGrade.getSecond()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grade not found"));

        return UserLoginDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .createAt(user.getCreatedAt())
                .grade(grade.getId())
                .build();
    }


    @PostMapping("users/{user_id}/questList")
    public TEST_QuestScreenDTO getQuestListController(@PathVariable("user_id") Long id){
        return userService.showQuestList(id);
    }

//    @PostMapping("/users/{user_id}/profile")
//    public UserProflieDTO profile(@PathVariable("user_id") Long id) {
//
//        Optional<User> user = userService.getUserById(id);
//        Optional<Grade> grade = itemService.getGrade(id);
//        List<Item> itemList = itemService.getItemList(id);
//        List<Grade> gradeList = itemService.getGradeList(user);
//
//        //DTO 제작
//        //등급 문자열 조작
//        String inputDescription;
//        if(gradeList.size() == 9)
//        {
//            inputDescription = "축하해요! 모든 시장 배지를 수집하셨어요!";
//        }
//        else{
//            int remainBadgeNum = 3 - (gradeList.size() % 3);
//            inputDescription = "화이팅! " + remainBadgeNum + "개만 더 모으면 " + grade.get().getName() + "이 될 수 있어요!";
//        }
//
//        //Badge 리스트 제작
//        List<Badge> badgeList = new ArrayList<>();
//
//        for(Item item : itemList) {
//            //acquireAt은 추후 아이템 획득 처리 기능 이후 작성한다.
//
//            Badge badge = Badge.builder()
//                    .id(item.getId())
//                    .name(item.getName())
//                    .acquisitionMethod(item.getType())
//                    .description(item.getProfileDescription())
//                    .imgUrl(item.getImage())
//                    .build();
//            badgeList.add(badge);
//        }
//
//        return UserProflieDTO.builder()
//                .nickname(user.get().getName())
//                .gradeDescription(inputDescription)
//                .characterName(grade.get().getName())
//                .previousImage(gradeList.get(0).getImage())
//                .currentImage(gradeList.get(1).getImage())
//                .nextImage(gradeList.get(2).getImage())
//                .badges(badgeList)
//                .build();
//    }
}
