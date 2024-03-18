package org.univ.dangol.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.Random;

@Entity
@Table(name="user")
@SuperBuilder(toBuilder = true)
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "name")
    private String nickname;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grade_id")
    private Grade grade;
//
//    @PrePersist
//    protected void onPrePersist() {
//        this.nickname = generateNickname();
//    }
//
//    private String generateNickname() {
//        // 형용사와 명사 배열을 정의
//        String[] adjectives = {"용감한", "멋진", "귀티나는", "잘생긴", "도전적인", "진취적인"};
//        String[] nouns = {"탐험가", "모험가", "여행자", "귀족", "용사", "방랑기사"};
//
//        // 랜덤으로 하나의 형용사와 명사를 선택
//        String adjective = adjectives[new Random().nextInt(adjectives.length)];
//        String noun = nouns[new Random().nextInt(nouns.length)];
//
//        // 선택된 형용사와 명사를 결합
//        return adjective + " " + noun;
//    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

}
