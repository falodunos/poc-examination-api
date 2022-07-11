package com.etz.pocexaminationapi.pocexaminationapi.repository;

import com.etz.pocexaminationapi.pocexaminationapi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
