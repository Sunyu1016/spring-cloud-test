package com.sunyu.provider_user_8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceProviderUser8002Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProviderUser8002Application.class, args);
    }
}
