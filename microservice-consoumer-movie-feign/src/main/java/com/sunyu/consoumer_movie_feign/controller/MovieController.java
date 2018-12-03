package com.sunyu.consoumer_movie_feign.controller;

import com.sunyu.consoumer_movie_feign.entity.User;
import com.sunyu.consoumer_movie_feign.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SunYu
 * @date 2018/12/3 8:55
 */
@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;
    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id){
        return userFeignClient.findById(id);
    }
}
