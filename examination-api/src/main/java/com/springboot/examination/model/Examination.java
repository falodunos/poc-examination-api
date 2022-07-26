package com.springboot.examination.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.examination.annotation.CustomDateValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.datetime.DateFormatter;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "examination")
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long exam_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String code;

//    @Column(nullable = false)
    @OneToOne(targetEntity = Levels.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "el_fk", referencedColumnName = "levels_id")
    private Levels levels;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String certificates;

//    @CustomDateValidator
    @Column(nullable = false, name = "date_established")
    private String dateEstablished;
}
