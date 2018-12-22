package com.sunyu.zuul_filter;

import com.sunyu.zuul_filter.filters.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class MicroserviceGatewayZuulFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceGatewayZuulFilterApplication.class, args);
    }
    @Bean
    public PreRequestLogFilter preRequestLogFilter(){
        return new PreRequestLogFilter();
    }

}

