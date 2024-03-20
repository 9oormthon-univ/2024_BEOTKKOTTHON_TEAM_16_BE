package org.univ.dangol.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.entity.*;
import org.univ.dangol.repository.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final GradeRepository gradeRepository;
    private final UserGradeRepository userGradeRepository;
    private final ItemRepository itemRepository;
    private final UserItemRepository userItemRepository;

    // 회원 가입
    @Transactional
    public Pair<Optional<User>, Optional<Grade>> join(String nickName) {

        Optional<User> findUser = userRepository.findByName(nickName);

        return findUser.map(user -> {
            // 사용자가 존재할 경우
            Optional<UserGrade> findUserGrade = userGradeRepository.findByUserOrderByGradeIdDesc(findUser.get());
            return Pair.of(Optional.of(user), Optional.of(findUserGrade.get().getGrade()));

        }).orElseGet(() -> {
            // 사용자가 존재하지 않을 경우, 새 사용자와 1번 캐릭터와 1번 아이템을 제공한다.
            Grade firstGrade = gradeRepository.findById(1L)
                    .orElseThrow(() -> new EntityNotFoundException("Error : Grade 발견 실패"));

            User newUser = User.builder()
                    .name(nickName)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            User registerUser = userRepository.save(newUser);

            UserGrade userGrade = UserGrade.builder()
                    .user(newUser)
                    .grade(firstGrade)
                    .build();

            userGradeRepository.save(userGrade);

            Optional<Item> firstItem = itemRepository.findById(1L);

            UserItem userItem = UserItem.builder()
                    .item(firstItem.get())
                    .user(newUser)
                    .acquireAt(LocalDateTime.now())
                    .build();

            userItemRepository.save(userItem);

            return Pair.of(Optional.of(registerUser), Optional.of(firstGrade));
        });
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
}


