package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter @Setter
public class LoginUserDTO {
    private Long id;
    private String name;

    //    grade repo 작업 후 진행
    //    private String grade;
}
