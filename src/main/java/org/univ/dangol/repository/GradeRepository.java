package org.univ.dangol.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.univ.dangol.entity.Grade;

import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    @NonNull Optional<Grade> findById(@NonNull Long id);
    @NonNull Optional<Grade> findByTier(@NonNull String tier);
    @NonNull Optional<Grade> findByName(@NonNull String name);
}
