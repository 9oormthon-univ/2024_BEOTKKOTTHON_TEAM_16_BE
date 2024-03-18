package org.univ.dangol.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Entity
@Table
@SuperBuilder(toBuilder = true)
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Collect {

    @Id @GeneratedValue
    private long id;

    @ManyToOne
    private Item item;

    @ManyToOne
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime collectedAt;
}
