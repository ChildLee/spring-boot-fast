package com.fast.security;

import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

/**
 * token持久化
 */
public class JdbcTokenRepository extends JdbcTokenRepositoryImpl {

    public int queryTokenCount(String username) {
        String sql = "select count(*) from persistent_logins where username=?";
        Object[] object = {username};
        return getJdbcTemplate().queryForObject(sql, object, int.class);
    }

}
