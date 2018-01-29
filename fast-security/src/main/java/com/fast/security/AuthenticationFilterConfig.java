package com.fast.security;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AuthenticationFilterConfig extends AbstractAuthenticationProcessingFilter {

    private static final String verifyCodeParameter = "verifyCode";

    protected AuthenticationFilterConfig() {
        super(new AntPathRequestMatcher("/login", "POST"));
        this.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/login?error"));
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if (!requiresAuthentication(request, response)) {
            chain.doFilter(request, response);
            return;
        }
        System.out.println("过滤器");

        String verifyCode = request.getParameter(verifyCodeParameter);
        System.out.println(verifyCode);

        if (false) {
            unsuccessfulAuthentication(request, response, new InsufficientAuthenticationException("验证码错误!"));
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        return null;
    }
}