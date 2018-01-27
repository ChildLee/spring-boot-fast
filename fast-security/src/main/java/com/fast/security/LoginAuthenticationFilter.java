package com.fast.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("过滤器");
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        System.out.println(username);
        System.out.println(password);

//        String inputCode = request.getParameter("code");
//        String code = request.getSession().getAttribute("code").toString();
//        if (!code.equals(inputCode)) {
//            throw new BadCredentialsException("验证码错误");
//        }
        return super.attemptAuthentication(request, response);
    }
}
