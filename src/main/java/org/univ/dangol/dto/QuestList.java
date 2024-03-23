package org.univ.dangol.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@Setter

/**
 * QuestScreen DTO
 * QuestList를 만들 때 사용되는 DTO이다.
 */

public class QuestList {
    private int sequence;
    private List<Quest> quests;
}
