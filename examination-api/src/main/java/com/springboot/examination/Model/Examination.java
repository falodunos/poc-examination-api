package com.springboot.examination.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "examination")
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String levels;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String certificates;

    @Column(nullable = false)
    private String dateEstablished;
}
