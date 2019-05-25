package com.simpel.springcloud.zull.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * 不拦截的路径
     */
    public static final List<String> IGNORE_PATHS;

    static {
        IGNORE_PATHS = new ArrayList<>();
        IGNORE_PATHS.add("/v2/api-docs");
        IGNORE_PATHS.add("/swagger-ui.html");
        IGNORE_PATHS.add("/swagger-resources/**");
        IGNORE_PATHS.add("/swagger/**");
        IGNORE_PATHS.add("/**/*.js");
        IGNORE_PATHS.add("/**/*.css");
        IGNORE_PATHS.add("/webjars/**");
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        // Swagger2 权限放行
        web.ignoring().antMatchers(IGNORE_PATHS.toArray(new String[IGNORE_PATHS.size()]));
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
    }

}

