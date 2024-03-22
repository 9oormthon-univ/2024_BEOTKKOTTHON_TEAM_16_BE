package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.univ.dangol.entity.PopupType;

import java.math.BigDecimal;

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class ItemDto {
    private Long Id;
    private PopupType type;

    // 다음 뱃지 획득을 위함
    private Long nextId;
    private BigDecimal nextLatitude;
    private BigDecimal nextLongitude;

    private String name;
    private String popupDescription;    // {emphasis}가 되신 것을 축하드립니다!
    private String profileDescription;
    private String image;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String quizConfirmText;
    private String quizWarningTitle;
    private String quizWarningImage;
    private String quizQuestion;
    private String quizPositive;
    private String quizNegative;

}
