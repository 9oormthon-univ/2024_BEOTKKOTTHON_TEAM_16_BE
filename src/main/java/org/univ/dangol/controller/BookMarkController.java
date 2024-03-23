package org.univ.dangol.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.univ.dangol.dto.BookmarkDto;
import org.univ.dangol.dto.BookmarkScreen;
import org.univ.dangol.entity.BookMark;
import org.univ.dangol.service.BookMarkService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookMarkController {

    private final BookMarkService bookMarkService;
    /**
     * setBookmark
     * 사용자가 북마크를 설정하는 기능
     * 상점 모달에서 별을 누르면 해당 shop이 북마크로 지정된다.
     *
     * 받아야 할 것은 해당 상점의 id와 사용자의 id
     * 보내야 하는 것은 해당 상점이 북마크로 지정되었는지 / 삭제되었는지
     * @return
     */
    @GetMapping("/users/{userId}/bookmarks")
    public BookmarkScreen bookmarkScreen(@PathVariable("userId") Long userId){
        return bookMarkService.getBookmarkedShopsForUser(userId);
    }

    // 별도 DTO
    @PostMapping("/users/{userId}/bookmarks/{shopId}")
    public BookmarkDto setBookmark(
            @PathVariable("userId") Long userId,
            @PathVariable("shopId") Long shopId
    ){
        Pair<BookMark, String> returnBookMark = bookMarkService.setBookmark(userId, shopId);
        if(returnBookMark.getSecond().equals("created")){
            return BookmarkDto.builder()
                    .bookmark(returnBookMark.getFirst())
                    .isBookmarked(true)
                    .build();
        }else{ //deleted
            return BookmarkDto.builder()
                    .bookmark(returnBookMark.getFirst())
                    .isBookmarked(false)
                    .build();
        }
    }
}
