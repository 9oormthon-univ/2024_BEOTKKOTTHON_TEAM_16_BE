package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class Reward {
    private int id;
    private boolean isAcquired;
    private boolean isUsed;
    private String imgUrl;
}
