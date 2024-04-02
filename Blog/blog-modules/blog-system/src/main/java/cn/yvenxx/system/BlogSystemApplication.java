package cn.yvenxx.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableDiscoveryClient
@SpringBootApplication
@EnableWebMvc
@EnableFeignClients
@MapperScan(basePackages = "cn.yvenxx.system.mapper")
@ComponentScan(basePackages = {"cn.yvenxx.common"})
public class BlogSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogSystemApplication.class, args);
    }

}
