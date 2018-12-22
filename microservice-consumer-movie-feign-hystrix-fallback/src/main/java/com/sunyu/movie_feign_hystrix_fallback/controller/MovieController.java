package com.sunyu.movie_feign_hystrix_fallback.controller;

import com.sunyu.movie_feign_hystrix_fallback.entity.User;
import com.sunyu.movie_feign_hystrix_fallback.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SunYu
 * @date 2018/12/5 16:32
 */
@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }
}
