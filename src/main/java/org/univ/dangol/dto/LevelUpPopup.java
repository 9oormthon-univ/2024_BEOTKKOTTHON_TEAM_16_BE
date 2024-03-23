package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class LevelUpPopup {
    // 티어 이미지
    private String tierImgUrl;
    // 팝업 타이틀
    private String title;
    // 등급 이름
    private String grade;
    // 캐릭터 이름
    private String characterImgUrl;
    // 캐릭터 설명
    private String description;
    // 상인회 위도
    private BigDecimal latitude;
    // 상인회 경도
    private BigDecimal longitude;
}
