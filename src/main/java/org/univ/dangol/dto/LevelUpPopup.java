package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class LevelUpPopup {
    // 티어 이미지
    private String tierImgUrl;
    // 레벨업 성공 시 레벨
    private Long level;
    // 팝업 타이틀
    private String title;
    // 등급 이름
    private String grade;
    // 캐릭터 이름
    private String characterImgUrl;
    // 캐릭터 설명
    private String description;
    // 상인회 위도, 경도
    private BadgePosition badgePosition;
}
