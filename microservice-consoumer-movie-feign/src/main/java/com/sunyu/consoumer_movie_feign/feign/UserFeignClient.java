package com.sunyu.consoumer_movie_feign.feign;

import com.sunyu.consoumer_movie_feign.config.FeignConfiguration;
import com.sunyu.consoumer_movie_feign.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author SunYu
 * @date 2018/12/3 16:58
 */
@FeignClient(name = "microservice-provider-user",configuration = FeignConfiguration.class)
public interface UserFeignClient {
    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);
}
