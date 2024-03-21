package org.univ.dangol.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@SuperBuilder(toBuilder = true)
@Jacksonized
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
}
