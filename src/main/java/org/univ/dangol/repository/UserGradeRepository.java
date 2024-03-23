package org.univ.dangol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.univ.dangol.entity.*;

import java.util.List;
import java.util.Optional;

public interface UserGradeRepository extends JpaRepository<UserGrade, Long> {

    Optional<UserGrade> findByUserAndGrade(User user, Grade grade);
    List<UserGrade> findByUserOrderByGradeIdDesc(User user);
    List<UserGrade> findAllByUser(User user);
}
