package com.etz.pocexaminationapi.pocexaminationapi.repository;

import com.etz.pocexaminationapi.pocexaminationapi.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExamRepository extends JpaRepository<Exam, Long> {
}
