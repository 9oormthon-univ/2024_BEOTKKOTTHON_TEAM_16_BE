package org.univ.dangol.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Jacksonized
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Item {

    @Id // 고정된 테이블 - 수동 pk 입력
    private Long Id;

    @Enumerated(EnumType.STRING)
    private ItemStatus type;

    @Column(length = 10)
    private String name;

    @Column(length = 20)
    private String emphasis;    // 용감한 탐험가

    @Column(length = 50)
    private String popupDescription;    // {emphasis}가 되신 것을 축하드립니다!

    @Column(length = 50)
    private String profileDescription;

    @Column(length = 255)
    private String image;

    //location Item 삭제, 모든 Item 에는 위치가 있음
    private BigDecimal latitude;
    private BigDecimal longitude;

    @Column(name = "quiz_warningconfirm_text")
    private String quizConfirmText;

    // 첫번째 퀴즈 팝업 페이지
    @Column(length = 50)
    private String quizWarningTitle;

    @Column(length = 255)
    private String quizWarningImage;


//    고정 메세지 - 별도 저장 X
//    @Column(length = 50)
//    private String quizDescription; (아래 문제를 맞추어.. 해결해보세요!)

    @Column(length = 50)
    private String quizQuestion;

    @Column(length = 10)
    private String quizPositive;

    @Column(length = 10)
    private String quizNegative;


//    // 고정 메시지 - 별도 저장 X
//    private String positive; (이어서 탐험하기)
//    private String negative; (도감 완성하기)

//    ID를 통해 판단할 수 있어 제외했다.
//    @Column(length = 10)
//    private String category;

}