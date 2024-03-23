package org.univ.dangol.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Elastic Bean Stalk에서 주기적인 health check를 위한 controller
// CD 과정을 위해서는 반드시 필요함
@RestController
public class HealthCheckController {
    @GetMapping("/health")
    public String index(){
        return "EC2 is health";
    }

}