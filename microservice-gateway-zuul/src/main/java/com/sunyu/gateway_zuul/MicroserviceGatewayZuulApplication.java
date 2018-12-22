package com.sunyu.gateway_zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//声明一个zuul代理，该代理使用ribbon来定位注册在Eureka Server中的微服务，同时该代理还整合了
//hystrix，从而实现了容错，所有经过zuul的请求都会在Hystrix命令中执行
@EnableZuulProxy
public class MicroserviceGatewayZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceGatewayZuulApplication.class, args);
    }
}
