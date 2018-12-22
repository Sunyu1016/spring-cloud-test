package com.sunyu.movie_feign_hystrix_fallbackfactory.feign;

import com.sunyu.movie_feign_hystrix_fallbackfactory.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author SunYu
 * @date 2018/12/5 16:27
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}

@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{
    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                // 日志最好放在各个fallback方法中，而不要直接放在create方法中。
                // 否则在引用启动时，就会打印该日志。
                // 详见https://github.com/spring-cloud/spring-cloud-netflix/issues/1471
                FeignClientFallbackFactory.LOGGER.info("fallback; reason was:", cause);
                User user = new User();
                user.setId(-1L);
                user.setUsername("默认用户");
                return user;
            }
        };
    }
}

