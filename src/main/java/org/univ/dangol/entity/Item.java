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
    private PopupType type;

    @Column(length = 10)
    private String name;

    @Column(length = 10)
    private String MarketName;

    @Column(length = 30)
    private String popupDescription;

    @Column(length = 30)
    private String profileDescription;

    @Column(length = 30)
    private String questDescription;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String image;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String unactivatedImage;

    //location Item 삭제, 모든 Item 에는 위치가 있음
    @Column(precision = 20, scale = 16)
    private BigDecimal latitude;

    @Column(precision = 20, scale = 16)
    private BigDecimal longitude;

    @Column
    private String quizConfirmText;

    // 첫번째 퀴즈 팝업 페이지
    @Column(length = 50)
    private String quizTitle;

    @Column(length = 255)
    private String quizWarningImage;

    @Column(length = 50)
    private String quizQuestion;

    @Column(length = 10)
    private String quizPositive;

    @Column(length = 10)
    private String quizNegative;
}