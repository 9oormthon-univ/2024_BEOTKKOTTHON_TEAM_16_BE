package org.univ.dangol.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.univ.dangol.entity.BookMark;
import org.univ.dangol.entity.User;

import java.util.Optional;

public interface BookMarkRepository extends JpaRepository<BookMark, Long> {
    @NonNull Optional<BookMark> findById(@NonNull Long id);
}
