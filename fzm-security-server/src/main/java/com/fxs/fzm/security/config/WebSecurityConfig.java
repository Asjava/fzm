package com.fxs.fzm.security.config;

import com.fxs.fzm.security.encode.MD5PasswordEncode;
import com.fxs.fzm.security.filter.JwtLoginFilter;
import com.fxs.fzm.security.filter.JwtVerifyFilter;
import com.fxs.fzm.security.service.IWebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Title: WebSecurityConfig 配置
 * Description:
 * Copyright: Copyright (c) 2020-09-14
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private IWebUserService webUserService;

    @Autowired
    private RsaKeyProperties rsaKeyProperties;

    @Bean
     public PasswordEncoder passwordEncoder() {
        return  new MD5PasswordEncode();
    }


    /**
     * 认证相关配置
     * {noop}不做加密处理
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("{noop}123")
//                .roles("USER");
        auth.userDetailsService(webUserService).passwordEncoder(passwordEncoder());
    }

    /**
     * Http资源配置
     * 资源释放、匹配到的路径进行认证、登录页配置、退出配置、csrf配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
//                .antMatchers("/**").hasAnyRole("USER","ADMIN")  // 角色认证
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new JwtLoginFilter(super.authenticationManager(), rsaKeyProperties))
                .addFilter(new JwtVerifyFilter(super.authenticationManager(), rsaKeyProperties))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 跨域配置
     * @return
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }


    //    /**
//     * Http资源配置
//     * 资源释放、匹配到的路径进行认证、登录页配置、退出配置、csrf配置
//     *
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/login.jsp","/failer.jsp","css/**","/img/**","/plugins/**").permitAll()
//                .antMatchers("/**").hasAnyRole("USER","ADMIN")  // 角色认证
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login.jsp")
//                .loginProcessingUrl("/login")
//                .successForwardUrl("/index.jsp")
//                .failureForwardUrl("/failer.jsp")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login.jsp")
//                .invalidateHttpSession(true)
//                .permitAll()
//                .and()
//                .csrf()
//                .disable();
//    }

}
