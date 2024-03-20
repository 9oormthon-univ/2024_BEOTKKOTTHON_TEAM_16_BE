package org.univ.dangol.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.service.AdventureService;
import org.univ.dangol.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AdventureController {

    private final UserService userService;
    private final AdventureService adventureService;

    @PostMapping("users/{user_id}/contact")
    public String contactItem(@PathVariable("user_id") Long id){

        adventureService.contactValidation(id);

        return "OK";
    }
}
