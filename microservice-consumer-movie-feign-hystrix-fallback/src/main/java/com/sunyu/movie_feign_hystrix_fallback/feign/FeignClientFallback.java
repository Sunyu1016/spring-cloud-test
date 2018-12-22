package com.sunyu.movie_feign_hystrix_fallback.feign;

import com.sunyu.movie_feign_hystrix_fallback.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author SunYu
 * @date 2018/12/5 16:35
 */
@Component
public class FeignClientFallback implements UserFeignClient{
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }
}
