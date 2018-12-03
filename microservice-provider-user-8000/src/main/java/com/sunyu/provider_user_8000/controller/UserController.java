package com.sunyu.provider_user_8000.controller;

import com.sunyu.provider_user_8000.entity.User;
import com.sunyu.provider_user_8000.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SunYu
 * @date 2018/12/3 11:46
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id){
        User findOne = userRepository.findOne(id);
        return findOne;
    }
}
