package org.univ.dangol.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class ProfileScreen {
    private String nickname;
    private String gradeDescription;
    private String characterName;
    private String currentImage;
    private String nextImage;
    private List<BookRow> bookRows;
}

