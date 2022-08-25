package com.example.demoproject.service;

import com.example.demoproject.model.Comment;
import com.example.demoproject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> getCommentList() {
        return commentRepository.findAll();
    }

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> findAllByProductId(Integer productId) {
        return commentRepository.findAllByProductID(productId);
    }

    public List<Comment> getFiveStar() {
        return commentRepository.findAllFiveStar();
    }
}
