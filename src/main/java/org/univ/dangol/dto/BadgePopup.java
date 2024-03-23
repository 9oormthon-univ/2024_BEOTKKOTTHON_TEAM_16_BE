package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class BadgePopup {
    // 뱃지 획득 타이틀
    private String title;
    // 뱃지에 대한 설명
    private String description;
    // 뱃지 이미지
    private String imgUrl;
}
