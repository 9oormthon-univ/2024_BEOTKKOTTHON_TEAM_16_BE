package org.univ.dangol.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.dto.UserProflieDTO;
import org.univ.dangol.entity.*;
import org.univ.dangol.repository.*;

import java.util.ArrayList;
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
    // 사용자가 다음에 얻어야 할 아이템 정보를 가져오는 함수 단순히 데이터 리딩 작업이라 판단되어  @Transactional(readOnly = true) 붙임
    // 모든 아이템 id는 각 아이템의 순서임을 가정하고 작업 ex: 첫 번째 아이템 모험의 시작 -> id 1
    @Transactional(readOnly = true)
    public Optional<Item> getNextItem(Long userId){
        long nextItemId =  userRepository.findById(userId)
                    .map(user -> userItemRepository.findByUser(user).size())
                    .orElse(0)+1 ; // 사용자가 없을 경우 0 반환
        return itemRepository.findById(nextItemId);
    }
    public List<Item> getItemList(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) return Collections.emptyList();

        List<UserItem> userItemList = userItemRepository.findByUser(user.get());

        return userItemList.stream()
                .map(UserItem::getItem)
                .collect(Collectors.toList());
    }

    public Optional<Grade> getGrade(Long userId) {
        return userRepository.findById(userId)
                .flatMap(userGradeRepository::findByUserOrderByGradeIdDesc)
                .map(UserGrade::getGrade);
    }




    public List<Grade> getGradeList(Optional<User> user){
        // 이전 단계와 이후 단계의 캐릭터를 반환한다.

        Optional<UserGrade> userGrade = userGradeRepository.findByUserOrderByGradeIdDesc(user.get());
        Grade grade = userGrade.get().getGrade();
        Long currentLevel = grade.getId();

        List<Grade> gradeList = new ArrayList<>();
        Grade dummyGrade = Grade.builder().characterEmptyImage("?").build();

        if(currentLevel == 1){
            // 1단계 일 경우, 이전 사진을 ?로 제공해야 한다.
            gradeList.add(dummyGrade);
            gradeList.add(grade);
            gradeList.add(dummyGrade);
        }else{
            gradeList.add(gradeRepository.findById(grade.getId() - 1).get());
            gradeList.add(grade);
            gradeList.add(dummyGrade);
        }
        return gradeList;
    }

}
