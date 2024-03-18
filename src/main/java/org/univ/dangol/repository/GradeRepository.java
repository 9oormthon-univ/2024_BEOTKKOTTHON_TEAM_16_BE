package org.univ.dangol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.univ.dangol.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade,Long> {
}
