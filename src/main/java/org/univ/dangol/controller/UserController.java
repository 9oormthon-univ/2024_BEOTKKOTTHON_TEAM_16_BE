package org.univ.dangol.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.dto.UserLoginDTO;
import org.univ.dangol.entity.User;
import org.univ.dangol.service.UserService;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    // 회원 가입 - POST
    @PostMapping("users/{nickName}")
    public UserLoginDTO join(@PathVariable("nickName") String nickName){
        Optional<User> user = userService.join(nickName);

        return UserLoginDTO.builder()
                .id(user.get().getId())
                .name(user.get().getName())
                .createAt(user.get().getCreatedAt())
                .build();
    }



}
