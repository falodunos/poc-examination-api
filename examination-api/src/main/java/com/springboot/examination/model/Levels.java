package com.springboot.examination.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "levels")
public class Levels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long levels_id;
    private String education;

    @OneToOne
    @JoinColumn(name = "levels_id")
    private Levels levels;
//    private String primaryEducation
//    private String secondaryEducation;
//    private String adultEducation;
//    private String tertiaryEducation;
}
