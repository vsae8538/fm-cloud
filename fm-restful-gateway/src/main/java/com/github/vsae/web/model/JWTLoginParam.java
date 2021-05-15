package com.github.vsae.web.model;

import javax.validation.constraints.NotEmpty;

public class JWTLoginParam {

    @NotEmpty(message = "使用者名不得為空")
    private String username;

    @NotEmpty(message = "密碼不能為空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
