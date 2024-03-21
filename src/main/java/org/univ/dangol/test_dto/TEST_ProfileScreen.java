package org.univ.dangol.test_dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class TEST_ProfileScreen {
    private String nickname;
    private String gradeDescription;
    private String characterName;
    private String previousImage;
    private String currentImage;
    private String nextImage;
    private List<Test_BookRow> BookRows;

}
