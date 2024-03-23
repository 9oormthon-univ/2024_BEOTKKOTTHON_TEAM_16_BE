package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Quiz에 대한 두번째 팝업
 */

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class QuizQuestionPopup {
    // 문제 타이틀
    private String title;
    // 문제에 대한 안내 스크립트
    private String description = "아래의 문제를 맞추어, 돌발 상황을 해결해보세요";
    // 문제
    private String question;
    // 정답
    private String positive;
    // 오답
    private String negative;
}
