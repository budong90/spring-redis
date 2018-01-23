package com.example.web.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author sunli
 * @create 2018-01-23 20:46
 */

public class RSAPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }
}
