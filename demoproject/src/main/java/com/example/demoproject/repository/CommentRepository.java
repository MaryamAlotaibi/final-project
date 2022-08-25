package com.example.demoproject.repository;

import com.example.demoproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    List<Comment> findAllByProductID(Integer productId);

    List<Comment> findAllFiveStar();
}
