package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class QuizWarningPopup {
    // 제목
    private String title;
    // 이미지 이름
    private String name;    // ex) 호랑이(어흥)
    // 이미지
    private String image;
    // 선택 메세지
    private String confirm;
}
