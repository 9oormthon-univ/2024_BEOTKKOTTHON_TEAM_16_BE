package org.univ.dangol.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

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
public class RewardItem extends Item {

    // 고정 메시지 - 별도 저장 X
    // title (축하드립니다😁)
    // description (꺄 트로피네요 ~ 상품을 받아보세요)
    // positive (시장상인회 이동하기)
    // negative (다음에 받기)
    private BigDecimal latitude;
    private BigDecimal longitude;
    private boolean isAcquired;
}
