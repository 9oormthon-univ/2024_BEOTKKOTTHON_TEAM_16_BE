package org.univ.dangol.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class BadgePopup {
    private String title;
    private String description;
    private String imgUrl;
    private String positive;
    private String negative;
    private Long id;
}
