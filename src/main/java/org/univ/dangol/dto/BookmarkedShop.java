package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.List;

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class BookmarkedShop {
    private long id;
    private String name;
    private String address;
    private String imgUrl;
    private String category;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private List<String> tags;
}
