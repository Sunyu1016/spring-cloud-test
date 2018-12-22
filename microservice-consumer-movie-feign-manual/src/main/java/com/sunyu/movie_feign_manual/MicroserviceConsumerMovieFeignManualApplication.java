package com.sunyu.movie_feign_manual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceConsumerMovieFeignManualApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieFeignManualApplication.class, args);
    }
}
