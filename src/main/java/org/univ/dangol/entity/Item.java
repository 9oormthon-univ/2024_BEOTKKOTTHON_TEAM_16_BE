package org.univ.dangol.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Item {

    @Id @GeneratedValue
    private Long Id;

    @Column(length = 10)
    private String name;

    @Column(length = 255)
    private String image;

    @Column(length = 10)
    private String category;

    @Column(length = 50)
    private String description;

}
