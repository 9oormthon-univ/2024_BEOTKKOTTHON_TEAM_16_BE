package org.univ.dangol.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private int id;
    @Column(name = "name")
    private String gradeName;
    @Column(name = "character_name")
    private String characterName;
    @Column(name = "character_image")
    private String characterImage;
    @Column(name = "character_description")
    private String characterDescription;
}