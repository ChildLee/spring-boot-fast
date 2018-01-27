package com.fast.security;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class AuthenticationProviderConfig implements AuthenticationProvider {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationProviderConfig.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsServiceConfig userDetailsServiceConfig;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //获取前端输入的用户名
        String username = authentication.getName();
        //获取前端输入的密码
        String password = authentication.getCredentials().toString();
        if ("".equals(username.trim()) || "".equals(password.trim())) {
            throw new BadCredentialsException("用户名或密码为空");
        }
        //数据库查询用户信息
        UserDetails user = userDetailsServiceConfig.loadUserByUsername(username);
        //判断密码
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("用户名或密码错误");
        }

//        repository.setDataSource(dataSource);
//        repository.removeUserTokens(username);
//        Long count = repository.queryTokenCount(username);
//        System.out.println(count);

        return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //返回true就会执行authenticate验证
        //返回false跳过该验证
        return true;
    }
}
