package com.example.demoproject.controller;

import com.example.demoproject.DTO.ApiResponse;
import com.example.demoproject.exception.InvalidIdException;
import com.example.demoproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class UserController {
    private final UserService userService;


    @GetMapping("users")
    public ResponseEntity getUser(){
        ArrayList<User> userList = userService.getUserList();
        return ResponseEntity.status(200).body(userList);
    }

    @PostMapping("register")
    public ResponseEntity<ApiResponse> addUser(@RequestBody @Valid User user){
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("New user added ",201));
    }

    @PutMapping("user/{id}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody @Valid User user,@PathVariable Integer id) throws InvalidIdException {
        userService.updateUser(user,id);
        return ResponseEntity.status(200).body(new ApiResponse("User is updated",201));
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id) throws InvalidIdException {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("User is deleted",201));
    }
}
