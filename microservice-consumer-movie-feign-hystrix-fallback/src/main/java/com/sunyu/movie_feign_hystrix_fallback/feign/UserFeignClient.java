package com.sunyu.movie_feign_hystrix_fallback.feign;

import com.sunyu.movie_feign_hystrix_fallback.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author SunYu
 * @date 2018/12/5 16:27
 */
@FeignClient(name = "microservice-provider-user",fallback = FeignClientFallback.class)
public interface UserFeignClient {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}

