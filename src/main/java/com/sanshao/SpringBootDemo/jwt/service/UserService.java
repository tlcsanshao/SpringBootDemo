package com.sanshao.SpringBootDemo.jwt.service;


import com.sanshao.SpringBootDemo.jwt.model.User;
import com.sanshao.SpringBootDemo.jwt.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public User getUserById(long id){
        return userRepository.findById(id).get();
    }

    public User getUserByUsername(User user){
        List<User> list = userRepository.findAll();
        for(User u:list){
            if(u.getUsername().equals(user.getUsername())){
                return u;
            }
        }
        return null;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }
}
