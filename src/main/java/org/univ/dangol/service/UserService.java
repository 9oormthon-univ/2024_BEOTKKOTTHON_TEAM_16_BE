package org.univ.dangol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.entity.User;
import org.univ.dangol.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원 가입
    @Transactional
    public Optional<User> join(String nickName){
        Optional<User> findUser = userRepository.findByName(nickName);
        if(findUser.isPresent()){
            return findUser;
        }else{
            // 1번 뱃지를 얻었다는 기록을 추가해야 한다.

            User newUser = User.builder()
                    .name(nickName)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            userRepository.save(newUser);
            return Optional.of(newUser);
        }
    }

}
