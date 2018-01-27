package com.fast.security;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTokenRepository repository;

    @Autowired
    private UserDetailsServiceConfig userDetailsServiceConfig;

    @Autowired
    private AuthenticationProviderConfig authenticationProviderConfig;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        //Token持久化
        repository.setDataSource(dataSource);
        return repository;
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsServiceConfig;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                //自定义密码验证
                .authenticationProvider(authenticationProviderConfig);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                //有效期内登陆会刷新数据库最后登录时间,并且过期时间重新计算
                .and().rememberMe().tokenRepository(persistentTokenRepository()).tokenValiditySeconds(60 * 60 * 24 * 7)
                .and().logout();
        //关闭csrf,使logout能使用get方式退出
        http.csrf().disable();
    }
}
