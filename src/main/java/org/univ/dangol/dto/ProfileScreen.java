package org.univ.dangol.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

/**
 * ProfileScreenDto
 *
 * Profile 페이지에서 item 객체를 전달하기 위해 사용한다.
 * BookRow로 각 item을 List화 하였다.
 */

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
