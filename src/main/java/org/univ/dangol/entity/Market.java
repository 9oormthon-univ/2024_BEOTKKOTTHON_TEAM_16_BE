package org.univ.dangol.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Entity
@Table
@SuperBuilder(toBuilder = true)
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Market {

    @Id
    private long id;

    @Column(length = 20)
    private String name;

    private String image;

    @Column(length = 50)
    private String description;

    private BigDecimal latitude;
    private BigDecimal longitude;

    // 태그는 기획단계에서 삭제
//    @Column(length = 20)
//    private String tag;

    // address로 하나의 String으로 조작하여 넣어야 함
    @Column(length = 10)
    private String region1Depth;

    @Column(length = 10)
    private String region2Depth;

    @Column(length = 10)
    private String region3Depth;

    @Column(length = 20)
    private String roadName;
}
