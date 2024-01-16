package com.proyect.walletmanagment.DataTypes;

import org.springframework.stereotype.Component;

@Component
public class AuthToken {
    public String token;

    public AuthToken() {
    }

    public AuthToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
