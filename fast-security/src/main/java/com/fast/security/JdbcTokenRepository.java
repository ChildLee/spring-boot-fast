package com.fast.security;

import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;


public class JdbcTokenRepository extends JdbcTokenRepositoryImpl {

    public Long queryTokenCount(String username) {
        String sql = "select count(*) from persistent_logins where username=?";
        Object[] object = {username};
        return getJdbcTemplate().queryForObject(sql, object, Long.class);
    }

}
