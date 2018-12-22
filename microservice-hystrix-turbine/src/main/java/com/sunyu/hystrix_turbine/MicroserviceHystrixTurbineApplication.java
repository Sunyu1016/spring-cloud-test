package com.sunyu.hystrix_turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
//import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
//@EnableTurbine
@EnableTurbineStream
public class MicroserviceHystrixTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceHystrixTurbineApplication.class, args);
    }
}
