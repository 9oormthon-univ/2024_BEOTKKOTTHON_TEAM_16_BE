package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@Getter
@Setter
public class UserLoginDto {
    private Long id;
    private String name;
    private LocalDateTime createAt;
    private Long grade;
}
