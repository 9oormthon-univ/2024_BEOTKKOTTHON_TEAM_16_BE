package org.univ.dangol.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
