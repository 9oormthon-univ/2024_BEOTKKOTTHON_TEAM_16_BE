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
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    private ItemType type;

    @Column(length = 10)
    private String name;

    @Column(length = 50)
    private String description;

    @Column(length = 255)
    private String image;

    //location Item 삭제, 모든 Item 에는 위치가 있음
    private BigDecimal latitude;
    private BigDecimal longitude;


//    // 고정 메시지 - 별도 저장 X
//    private String positive; (이어서 탐험하기)
//    private String negative; (도감 완성하기)

//    ID를 통해 판단할 수 있어 제외했다.
//    @Column(length = 10)
//    private String category;

}

enum ItemType{
    Quiz, Location, Reward;
}