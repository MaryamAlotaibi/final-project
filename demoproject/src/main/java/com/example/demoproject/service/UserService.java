package com.example.demoproject.service;

import com.example.demoproject.exception.InvalidIdException;
import com.example.demoproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@RequiredArgsConstructor
public class UserService {
    ArrayList<User> userList=new ArrayList<User>();
    private final MerchantStockService merchantStockService;
    private final ProductService productService;
    private final UserRepository userRepository;
    public Object getUsers() {
        return userRepository.findAll();
    }
    public ArrayList<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        String hashedPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    public void updateUser(User user, Integer id) throws InvalidIdException {
        User user1 = userRepository.findById(id)
                .orElseThrow(
                        ()-> new InvalidIdException("Invalid user id"));
        userRepository.save(user);
    }

    public void deleteUser(Integer id) throws InvalidIdException {
        User user1 = userRepository.findById(id)
                .orElseThrow(
                        ()-> new InvalidIdException("Invalid user id"));
        userRepository.deleteById(id);

    }

}
