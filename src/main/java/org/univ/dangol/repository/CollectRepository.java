package org.univ.dangol.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.univ.dangol.entity.Collect;
import org.univ.dangol.entity.User;

import java.util.Optional;

public interface CollectRepository extends JpaRepository<Collect, Long> {
    @NonNull Optional<Collect> findById(@NonNull Long id);
    @NonNull Optional<Collect> findByUser(@NonNull User user);
}
