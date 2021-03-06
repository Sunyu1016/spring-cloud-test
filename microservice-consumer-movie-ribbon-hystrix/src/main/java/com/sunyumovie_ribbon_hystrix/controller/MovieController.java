package com.sunyumovie_ribbon_hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.sunyumovie_ribbon_hystrix.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author SunYu
 * @date 2018/12/5 14:45
 */
@RestController
public class MovieController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //ignoreExceptions:发生该异常时，不触发fallback
    @HystrixCommand(fallbackMethod = "findByIdFallback",ignoreExceptions = {IllegalArgumentException.class})
    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }
    public User findByIdFallback(Long id, Throwable throwable){
        LOGGER.info("进入回退方法，异常：",throwable);
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }
    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        // 打印当前选择的是哪个节点
        MovieController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }
}
