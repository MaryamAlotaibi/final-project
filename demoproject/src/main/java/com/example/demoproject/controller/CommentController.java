package com.example.demoproject.controller;

import com.example.demoproject.DTO.ApiResponse;
import com.example.demoproject.model.Comment;
import com.example.demoproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class CommentController {

    private final CommentService commentService;


    @GetMapping("comment")
    public ResponseEntity<List<Comment>> getComment() {
        List<Comment> commentList = commentService.getCommentList();
        return ResponseEntity.status(200).body(commentList);
    }

    @PostMapping("add-comment")
    public ResponseEntity addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Comment added !",201));
    }

    @GetMapping("product/{productId}")
    public ResponseEntity<Object> getAllProductComment(@PathVariable("productId") Integer productId){
        return  ResponseEntity.status(200).body(commentService.findAllByProductId(productId));
    }


    @GetMapping("rate")
    public ResponseEntity<List<Comment>> getFiveStar(){
        List<Comment> reviews = commentService.getFiveStar();
        return ResponseEntity.status(200).body(reviews);
    }

}
