package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@Getter @Setter
public class UserLoginDTO {
    private Long id;
    private String name;
    private LocalDateTime createAt;


    //    grade repo 작업 후 진행
    //    private String grade;
}
