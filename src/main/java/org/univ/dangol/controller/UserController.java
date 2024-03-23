package org.univ.dangol.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.univ.dangol.dto.ProfileScreen;
import org.univ.dangol.dto.QuestList;
import org.univ.dangol.dto.UserLoginDto;
import org.univ.dangol.entity.Grade;
import org.univ.dangol.entity.User;
import org.univ.dangol.service.ItemService;
import org.univ.dangol.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ItemService itemService;
    // 회원 가입 - POST


    @PostMapping("users/{userId}/trophy/{trophyId}")
    public Map<String, Boolean> useTrophy(@PathVariable("userId") Long userId, @PathVariable("trophyId") Long trophyId){
        // 사용자 id와 trophy

        Map<String, Boolean> resultTrophy = new HashMap<String, Boolean>();
        if(itemService.trophyUseService(userId, trophyId)){
            resultTrophy.put("isFinished", true);
            return resultTrophy;
        }else{
            resultTrophy.put("isFinished", false);
            return resultTrophy;
        }
    }

    @PostMapping("users/{nickName}")
    public UserLoginDto join(@PathVariable("nickName") String nickName) {
        Pair<Optional<User>, Optional<Grade>> userAndGrade = userService.join(nickName);

        User user = userAndGrade.getFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Grade grade = userAndGrade.getSecond()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grade not found"));

        int userItemCount = userService.getUserItemCount(nickName);
        return UserLoginDto.builder()
                .id(user.getId())
                .name(user.getName())
                .createAt(user.getCreatedAt())
                .grade(grade.getId())
                .getUserItemCount(userItemCount)
                .build();
    }

    @GetMapping("users/{user_id}/questList")
    public QuestList getQuestListController(@PathVariable("user_id") Long id){
        return userService.showQuestList(id);
    }

    @GetMapping("/users/{userId}/profile")
    public ProfileScreen profile(@PathVariable("userId") Long id){
        return userService.showProfile(id);
    }

    @PostMapping("/users/{userId}/profile/trophy/{trophyId}")
    public String getTrophyInfo(@PathVariable("userId") Long id){
        // 트로피를 눌렀을 때 두가지 분기가 등장한다.
        // 1. 트로피를 처음 눌렀을 경우 - 레벨업과 트로피 획득 팝업이 뜬다
        // 2. 두번째 트로피를 눌렀을 경우 - 쿠폰 관련 내용이 뜬다.

        return "OK";
    }
}
