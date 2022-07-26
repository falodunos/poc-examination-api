package com.springboot.examination.repository;

import com.springboot.examination.model.Levels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelsRepository extends JpaRepository<Levels, Long> {
}
