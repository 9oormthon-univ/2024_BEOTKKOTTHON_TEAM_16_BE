package org.univ.dangol.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.univ.dangol.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @NonNull Optional<User> findById(@NonNull Long id);
    Optional<User> findByName(String name);
}
