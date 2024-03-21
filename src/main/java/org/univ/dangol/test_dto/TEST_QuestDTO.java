package org.univ.dangol.test_dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class TEST_QuestDTO {
    private Long id;
    private String name;
    private String description;
    private boolean isAcquired;
    private String imgUrl;
}
