package org.univ.dangol.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Entity
@Table
@SuperBuilder(toBuilder = true)
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Grade {
    @Id // 고정된 테이블 - 수동 pk 입력
    private Long id;

    @Column(length = 15)
    private String tier;    // (`Gold` Level UP)

    @Lob
    @Column(columnDefinition = "TEXT")
    private String characterImage;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String characterEmptyImage;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String trophyImage;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String trophyEmptyImage;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String trophyRibbonImage;

    @Column(length = 15)
    private String name;    // 장터 수호자

    @Column
    public boolean isUsed;


    // 고정 메시지 - 별도 저장 X
    // description (우와 벌써 뱃지를 `5`개나 획득..)
    // confirm     (이어서 탐색하기)

}
