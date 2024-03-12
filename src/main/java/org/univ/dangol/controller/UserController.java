package org.univ.dangol.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.univ.dangol.dto.UserDto;
import org.univ.dangol.entity.User;
import org.univ.dangol.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    // UserDto to User Entity
    private User dtoToEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .nickName(userDto.getNickName())
                .age(userDto.getAge())
                .build();
    }

    // User Entity to UserDto
    private UserDto entityToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .nickName(user.getNickName())
                .age(user.getAge())
                .build();
    }

    // 모든 사용자 조회
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    // 특정 사용자 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> new ResponseEntity<>(entityToDto(user), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 사용자 생성
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = dtoToEntity(userDto);
        user = userRepository.save(user);
        return entityToDto(user);
    }

    // 사용자 정보 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setNickName(userDto.getNickName());
                    existingUser.setAge(userDto.getAge());
                    userRepository.save(existingUser);
                    return new ResponseEntity<>(entityToDto(existingUser), HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 사용자 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
