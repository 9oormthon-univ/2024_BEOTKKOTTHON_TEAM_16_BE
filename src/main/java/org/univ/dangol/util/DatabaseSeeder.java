//package org.univ.dangol.util;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.univ.dangol.entity.Grade;
//import org.univ.dangol.entity.User;
//import org.univ.dangol.repository.GradeRepository;
//import org.univ.dangol.repository.UserRepository;
//
//import java.util.Arrays;
//
//@Component
//@RequiredArgsConstructor
//public class DatabaseSeeder implements CommandLineRunner {
//    private final GradeRepository gradeRepository;
//    private final UserRepository userRepository;
//    @Override
//    public void run(String... args) throws Exception {
//        // 기존 Grade 엔티티가 존재하는지 확인하고, 없으면 생성
//        long gradeCount = gradeRepository.count();
//        if (gradeCount < 1) {
//            Grade grade1 = new Grade();
//            grade1.setGradeName("장터 구경꾼");
//            grade1.setCharacterName("이상해씨");
//            grade1.setCharacterImage("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png");
//            grade1.setCharacterDescription("1단계 여행하장 임시 마스코트");
//
//            Grade grade2 = new Grade();
//            grade2.setGradeName("장터 탐험가");
//            grade2.setCharacterName("이상해풀");
//            grade2.setCharacterImage("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png");
//            grade2.setCharacterDescription("2단계 여행하장 임시 마스코트");
//
//            Grade grade3 = new Grade();
//            grade3.setGradeName("장터 보물사냥꾼");
//            grade3.setCharacterName("이상해꽃");
//            grade3.setCharacterImage("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png");
//            grade3.setCharacterDescription("3단계 여행하장 임시 마스코트");
//            gradeRepository.saveAll(Arrays.asList(grade1, grade2, grade3));
//        }
//
//        // User 엔티티에 대한 더미 데이터 생성 및 저장
//        createUserWithDetails("잘생긴 용사", 1L);
//        createUserWithDetails("용감한 귀족", 2L);
//        createUserWithDetails("진취적인 모험가", 1L);
//        createUserWithDetails("용감한 여행자", 3L);
//    }
//
//    private void createUserWithDetails(String nickname, Long gradeId) {
//        User user = new User();
//        user.setNickname(nickname); // 직접 닉네임 설정
//        user.setGrade(gradeRepository.findById(gradeId).orElse(null)); // grade_id를 통해 Grade 엔티티 참조
//        userRepository.save(user);
//    }
//}
