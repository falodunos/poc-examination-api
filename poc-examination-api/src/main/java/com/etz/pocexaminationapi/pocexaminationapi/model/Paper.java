package com.etz.pocexaminationapi.pocexaminationapi.model;

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
        name = "Paper" /**, uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}*/
)
public class Paper {
    

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;


}
