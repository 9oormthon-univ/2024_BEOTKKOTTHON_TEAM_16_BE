package org.univ.dangol.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.univ.dangol.entity.BookMark;

/**
 * 북마크 관련 Dto
 * 삭제될 예정 String으로 변환하는게 합리적일 수 있다.
 */

@SuperBuilder(toBuilder = true)
@Jacksonized
@Getter
@Setter
public class BookmarkDto {
    // 등록되면 created
    // 삭제되면 deleted
    boolean isBookmarked;
    BookMark bookmark;
}
