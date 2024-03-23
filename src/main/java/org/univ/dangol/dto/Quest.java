package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter

/**
 * Quest
 *
 * QuestListDto의 구성요소. QuestList 구성 시 사용된다.
 */

public class Quest {
    private Long id;
    private String name;
    private Boolean isAcquired;
    private String description;
    private String imgUrl;
}
