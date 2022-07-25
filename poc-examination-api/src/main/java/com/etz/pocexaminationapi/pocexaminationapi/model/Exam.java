package com.etz.pocexaminationapi.pocexaminationapi.model;

import com.etz.pocexaminationapi.pocexaminationapi.annotations.CustomDateConstraint;
import com.etz.pocexaminationapi.pocexaminationapi.annotations.PaperIdConstraint;
import com.etz.pocexaminationapi.pocexaminationapi.annotations.StatusValidator;
import com.etz.pocexaminationapi.pocexaminationapi.annotations.ToUpperCaseDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@EntityListeners(EntityListeners.class)
@Table(
        name = "Exam" /**, uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}*/
)
public class Exam {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT",name = "description", nullable = false)
    private String description;

    @Column(name = "code", nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "Paper_id")
    @PaperIdConstraint
    private Paper paper;

    @Column(name = "status", nullable = false)
    @JsonDeserialize(using = ToUpperCaseDeserializer.class)
    @StatusValidator()
    private String status;

    @Column(name = "certificates", nullable = false)
    private String certificates;

    @Column(name = "date_established", nullable = false)
    @CustomDateConstraint
    private String date_established;

}
