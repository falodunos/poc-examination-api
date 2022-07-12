package com.springboot.examination.Repository;

import com.springboot.examination.Model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {
}
