package org.univ.dangol.test_dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.univ.dangol.entity.ItemStatus;

import java.math.BigDecimal;

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class TEST_ItemDTO {
    private Long Id;
    private ItemStatus type;
    private String name;
    private String emphasis;    // 용감한 탐험가
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
