package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class Trophy{
    private Long Id;
    private Boolean isAcquired;
    private Boolean isUsed;
    private Boolean imgUrl;
}
