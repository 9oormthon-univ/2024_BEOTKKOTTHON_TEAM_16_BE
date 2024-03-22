package org.univ.dangol.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.univ.dangol.entity.BookMark;

@SuperBuilder
@Getter
@Setter
public class BookMarkDTO {
    // 등록되면 created
    // 삭제되면 deleted
    String status;
    BookMark bookmark;
}
