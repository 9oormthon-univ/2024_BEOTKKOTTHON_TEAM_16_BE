package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class QuizPopup {
    // 첫번째 퀴즈 팝업
    private QuizWarningPopup quizWarningPopup;
    // 두번째 퀴즈 팝업
    private QuizQuestionPopup quizQuestionPopup;
}
