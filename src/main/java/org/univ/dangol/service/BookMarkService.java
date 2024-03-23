package org.univ.dangol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.entity.BookMark;
import org.univ.dangol.entity.Shop;
import org.univ.dangol.entity.User;
import org.univ.dangol.repository.BookMarkRepository;
import org.univ.dangol.repository.ShopRepository;
import org.univ.dangol.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookMarkService {

    private final BookMarkRepository bookMarkRepository;
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;

    @Transactional
    public Pair<BookMark, String> setBookmark(Long user_id, Long shop_id){

        User user = userRepository.findById(user_id).get();
        Shop shop = shopRepository.findById(shop_id).get();

        //userId와 shopId를 통해 해당 bookmark가 있는지 확인한다.
        Optional<BookMark> bookmark = bookMarkRepository.findByUserAndShop(user, shop);

        if(bookmark.isEmpty()){
            //bookmark가 없으면 북마크 지정을 성공했다는 메시지를 보낸다.
             BookMark newBookmark = BookMark.builder()
                     .user(user)
                     .shop(shop)
                     .build();
             bookMarkRepository.save(newBookmark);
            Pair<BookMark, String> created = Pair.of(newBookmark, "created");
            return created;
        }
        else{
            //bookmark가 있으면 해당 북마크를 삭제하고, 삭제한 북마크를 재전송한다.
            bookMarkRepository.delete(bookmark.get());
            Pair<BookMark, String> deleted = Pair.of(bookmark.get(), "deleted");
            return deleted;
        }
    }
}
