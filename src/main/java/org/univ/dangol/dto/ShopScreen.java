package org.univ.dangol.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@Setter
public class ShopScreen {
    private List<ShopDTO> shops;
    private Position position;
}

