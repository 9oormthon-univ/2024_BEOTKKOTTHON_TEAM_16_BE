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
public class LocationItem extends Item{
    private BigDecimal latitude;
    private BigDecimal longitude;
}
