package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class RecommendMarket {
    private int id;
    private String description;
    private String imgUrl;
    private double latitude;
    private double longitude;
}
