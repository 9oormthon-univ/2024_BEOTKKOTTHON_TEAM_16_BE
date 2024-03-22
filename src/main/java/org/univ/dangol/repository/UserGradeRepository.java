package org.univ.dangol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.univ.dangol.entity.Grade;
import org.univ.dangol.entity.User;
import org.univ.dangol.entity.UserGrade;

import java.util.List;
import java.util.Optional;

public interface UserGradeRepository extends JpaRepository<UserGrade, Long> {

    List<UserGrade> findByUserOrderByGradeIdDesc(User user);
    List<UserGrade> findByUser(User user);
}
