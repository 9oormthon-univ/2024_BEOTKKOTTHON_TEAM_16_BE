package org.univ.dangol.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
@NoArgsConstructor
public class ProfileScreen {
    private String nickname;
    private String gradeDescription;
    private String characterName;
    private String previousImage;
    private String currentImage;
    private String nextImage;
    private List<BookRow> bookRows;

}
