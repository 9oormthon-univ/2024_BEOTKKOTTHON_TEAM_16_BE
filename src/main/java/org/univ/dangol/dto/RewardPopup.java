package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class RewardPopup {
    private String title;
    private String description;
    private String imgUrl;
    private String positive;
    private String negative;
    private double latitude;
    private double longitude;
}
