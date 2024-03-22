package org.univ.dangol.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.dto.BookMarkDTO;
import org.univ.dangol.entity.BookMark;
import org.univ.dangol.repository.BookMarkRepository;
import org.univ.dangol.service.BookMarkService;

import java.util.Optional;

@Slf4j
@RestController
public class BookMarkController {

    BookMarkService bookMarkService;

    /**
     * setBookmark
     * 사용자가 북마크를 설정하는 기능
     * 상점 모달에서 별을 누르면 해당 shop이 북마크로 지정된다.
     *
     * 받아야 할 것은 해당 상점의 id와 사용자의 id
     * 보내야 하는 것은 해당 상점이 북마크로 지정되었는지 / 삭제되었는지
     * @return
     */

    // 별도 DTO
    @PostMapping("/users/{userId}/bookmarks/{shopId}")
    public BookMarkDTO setBookmark(
            @PathVariable("userId") Long userId,
            @PathVariable("shopId") Long shopId
    ){
        Pair<BookMark, String> returnBookMark = bookMarkService.setBookmark(userId, shopId);
        if(returnBookMark.getSecond().equals("created")){
            return BookMarkDTO.builder()
                    .bookmark(returnBookMark.getFirst())
                    .status("created")
                    .build();
        }else{ //deleted
            return BookMarkDTO.builder()
                    .bookmark(returnBookMark.getFirst())
                    .status("deleted")
                    .build();
        }
    }

}