package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class LevelUpIntroducePopup {
    private String title;
    private String grade;
    private String imgUrl;
    private String tierImgUrl;
    private String description;
    private String confirm;
}
