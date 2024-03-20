package org.univ.dangol.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Entity
@Table
//@SuperBuilder(toBuilder = true)
//@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class QuizItem extends Item {


    // 첫번째 팝업 페이지
    @Column(length = 50)
    private String quizWarningTitle;

    @Column(length = 15)
    private String quizWarningconfirmText;

    @Column(length = 255)
    private String quizWarningImage;


    // 두번째 팝업 페이지
    @Column(length = 50)
    private String quizTitle;

//    고정 메세지 - 별도 저장 X
//    @Column(length = 50)
//    private String quizDescription; (아래 문제를 맞추어.. 해결해보세요!)

    @Column(length = 50)
    private String quizQuestion;

    @Column(length = 10)
    private String quizPositive;

    @Column(length = 10)
    private String quizNegative;

}
