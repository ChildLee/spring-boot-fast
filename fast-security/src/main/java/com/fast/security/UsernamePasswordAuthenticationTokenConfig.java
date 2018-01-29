package com.fast.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UsernamePasswordAuthenticationTokenConfig extends UsernamePasswordAuthenticationToken {
    public UsernamePasswordAuthenticationTokenConfig(String principal, String credentials, String validateCode) {
        super(principal, credentials);
        this.validateCode = validateCode;
    }

    private String validateCode;

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }
}
