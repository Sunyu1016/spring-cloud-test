package com.sunyu.consoumer_movie_feign.config;

/**
 * @author SunYu
 * @date 2018/12/3 17:12
 */
import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * 该类为Feign的配置类
 * 可以不加@Configuration注解
 * 注意：如果加了@Configuration注解，该类不应该在主应用程序上下文的@ComponentScan中。
 */
public class FeignConfiguration {
    /**
     * 将契约改为feign原生的默认契约。这样就可以使用feign自带的注解了。
     * @return 默认的feign契约
     */
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
//        return new BasicAuthRequestInterceptor("user","password");
//    }
}
