package org.univ.dangol.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.univ.dangol.dto.UserDto;
import org.univ.dangol.entity.User;
import org.univ.dangol.repository.UserRepository;

import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    // 아래 해당 구체적인 로직 과정 service로 분리 권장 TO DO
    // UserDto to User Entity
    private User dtoToEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .nickname(userDto.getNickName())
                .grade(userDto.getGrade())
                .build();
    }

    // User Entity to UserDto
    private UserDto entityToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .nickName(user.getNickname())
                .grade(user.getGrade())
                .build();
    }
    // ResponseEntity<?>
    // 모든 사용자 조회
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> dto = userRepository.findAll().stream()
                .map(this::entityToDto)
                .toList();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok()
                .headers(headers)
                .body(dto);
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
                    existingUser.setNickname(userDto.getNickName());
                    existingUser.setGrade(userDto.getGrade());
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
