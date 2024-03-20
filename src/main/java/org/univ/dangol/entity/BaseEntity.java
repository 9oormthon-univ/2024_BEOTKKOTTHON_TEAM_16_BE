package org.univ.dangol.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@SuperBuilder(toBuilder = true)
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @CreatedDate
    protected LocalDateTime createdDate;
    @LastModifiedDate
    protected LocalDateTime modifiedDate;
}

