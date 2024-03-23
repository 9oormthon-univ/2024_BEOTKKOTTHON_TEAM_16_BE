package org.univ.dangol.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.entity.*;
import org.univ.dangol.repository.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final UserItemRepository userItemRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final GradeRepository gradeRepository;
    private final UserGradeRepository userGradeRepository;


    public Boolean trophyUseService(Long userId, Long gradeId){

        User user = userRepository.findById(userId).get();
        Grade grade = gradeRepository.findById(gradeId).get();
        UserGrade userGrade = userGradeRepository.findByUserAndGrade(user, grade).get();

        if(!userGrade.isUsed)
        {
            userGrade.isUsed = true;
            return true;
        }
        else{
            return false;
        }
    }

    public Item getItem(Long id){
        return itemRepository.findById(id).get();
    }

    // 사용자가 다음에 얻어야 할 아이템 정보를 가져오는 함수 단순히 데이터 리딩 작업이라 판단되어  @Transactional(readOnly = true) 붙임
    // 모든 아이템 id는 각 아이템의 순서임을 가정하고 작업 ex: 첫 번째 아이템 모험의 시작 -> id 1
    @Transactional(readOnly = true)
    public Optional<Item> getNextItem(Long userId){
        long nextItemId =  userRepository.findById(userId)
                    .map(user -> userItemRepository.findAllByUser(user).size())
                    .orElse(0)+1 ; // 사용자가 없을 경우 0 반환
        return itemRepository.findById(nextItemId);
    }

    public Item findByItemIdNextItem(Item item){
        return itemRepository.findById(item.getId() + 1).get();
    }

    public List<Item> getItemList(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) return Collections.emptyList();

        List<UserItem> userItemList = userItemRepository.findAllByUser(user.get());

        return userItemList.stream()
                .map(UserItem::getItem)
                .collect(Collectors.toList());
    }


}
