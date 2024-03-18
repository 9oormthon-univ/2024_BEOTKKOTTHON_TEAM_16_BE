package org.univ.dangol.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Entity
@Table
@SuperBuilder(toBuilder = true)
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BookMark {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Shop shop;

    @ManyToOne
    private User user;
}
