package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@Setter
public class ShopDTO {
    private long id;
    private String name;
    private String address;
    private String imgUrl;
    private String category;
    private List<String> tags;
    private Double latitude;
    private Double longitude;
    private boolean isBookmarked;
}
