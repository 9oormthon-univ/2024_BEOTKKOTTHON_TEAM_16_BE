package org.univ.dangol.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Entity
@Table
//@SuperBuilder(toBuilder = true)
//@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class QuizItem extends Item {

    @Column(length = 50)
    private String problem;

    @Column(length = 10)
    private String answer;

}
