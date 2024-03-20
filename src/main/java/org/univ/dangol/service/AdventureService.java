package org.univ.dangol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.entity.ItemStatus;
import org.univ.dangol.entity.User;
import org.univ.dangol.entity.UserGrade;
import org.univ.dangol.repository.UserGradeRepository;
import org.univ.dangol.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdventureService {

    private final UserRepository userRepository;
    private final UserGradeRepository userGradeRepository;
    List<ItemStatus> itemSeq = Arrays.asList(
            // 아이템의 고정된 종류를 리스트에 사전 저장한다.
            ItemStatus.APP, ItemStatus.Location, ItemStatus.APP,
            ItemStatus.Quiz, ItemStatus.Location, ItemStatus.Quiz,
            ItemStatus.Quiz, ItemStatus.Location, ItemStatus.Location
    );

    @Transactional
    public void contactValidation(Long id){

        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            List<UserGrade> gradeList = userGradeRepository.findAll();
        }
    }
}
