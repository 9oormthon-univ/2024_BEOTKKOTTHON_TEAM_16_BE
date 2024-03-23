package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.univ.dangol.entity.PopupType;

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class TouchResponse {
    // 발생한 이벤트의 종류
    // APP, LOCATION, QUIZ
    private PopupType popupType;

    // 다음 뱃지에 대한 정보를 제공한다.
    private BadgePosition badgePosition;

    // badgePopup, App, Location, Quiz 모두 사용한다
    private BadgePopup badgePopup;
    // quizPopup - Quiz 만 사용한다.
    private QuizPopup quizPopup;
}
