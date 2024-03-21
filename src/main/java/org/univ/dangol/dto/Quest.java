package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@Setter
public class Quest {
    private int id;
    private String name;
    private Boolean isAcquired;
    private String description;
    private String imgUrl;
}
