package org.univ.dangol.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.univ.dangol.dto.BadgePopup;

import java.nio.charset.Charset;

@Slf4j
@RestController
public class TempRewardController {
    @PostMapping("/users/{userId}/rewards")
    public ResponseEntity<?> useReward(@PathVariable Long userId, @RequestBody Long rewardId) {
        // TO DO CHANGE REGION

        return ResponseEntity
                .status(HttpStatus.NOT_IMPLEMENTED)
                .body("This feature has not been implemented yet.");
    }
}
