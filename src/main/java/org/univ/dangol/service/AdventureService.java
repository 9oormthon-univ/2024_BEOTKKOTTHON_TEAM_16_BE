package org.univ.dangol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.univ.dangol.entity.Collect;
import org.univ.dangol.entity.User;
import org.univ.dangol.repository.CollectRepository;
import org.univ.dangol.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdventureService {

    private final UserRepository userRepository;
    private final CollectRepository collectRepository;

    @Transactional
    public void contactValidation(Long id){

        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            Optional<Collect> collect = collectRepository.findById(id);
        }


    }

}
