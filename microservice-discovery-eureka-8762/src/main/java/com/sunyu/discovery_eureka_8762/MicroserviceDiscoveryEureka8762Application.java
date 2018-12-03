package com.sunyu.discovery_eureka_8762;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceDiscoveryEureka8762Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDiscoveryEureka8762Application.class, args);
    }
}
