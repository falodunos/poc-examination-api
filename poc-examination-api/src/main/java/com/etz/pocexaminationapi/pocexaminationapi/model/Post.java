package com.etz.pocexaminationapi.pocexaminationapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "creates", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
public class Post {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "levels", nullable = false)
    private String levels;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "certificates", nullable = false)
    private String certificates;

    @Column(name = "date_established", nullable = false)
    private LocalDate date_established;

}
