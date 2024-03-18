package cn.yvenxx.config;

import cn.yvenxx.filter.JwtAuthenticationFilter;
import cn.yvenxx.filter.JwtAuthorizationFilter;
import cn.yvenxx.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

// 开启 Security
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfiguration{
    @Autowired
    private UserDetailServiceImpl userDetailsServiceImpl;
    // Spring Boot 的 CacheManager，这里我们使用 JCache
    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 开启跨域
        http.cors()
                .and()
                // security 默认 csrf 是开启的，我们使用了 token ，这个也没有什么必要了
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .anyRequest().authenticated()
                .and()
                // 添加自己编写的两个过滤器
                // 前后端分离是 STATELESS，故 session 使用该策略
                .addFilterAt(new JwtAuthenticationFilter(authenticationManager), UsernamePasswordAuthenticationFilter.class)
                .addFilterAt(new JwtAuthorizationFilter(authenticationManager), BasicAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
