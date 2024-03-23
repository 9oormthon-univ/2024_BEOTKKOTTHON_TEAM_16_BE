package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class BadgePosition {
    private BigDecimal latitude;
    private BigDecimal longitude;
}
