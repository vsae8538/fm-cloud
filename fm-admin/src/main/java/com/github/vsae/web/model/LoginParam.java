package com.github.vsae.web.model;


import com.github.vsae.api.resource.utils.ConstantSet;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LoginParam {

    @NotNull
    //@Pattern(regexp = ConstantSet.USERNAME_REGEXP)
    private String userName;

    @NotNull
    //@Pattern(regexp = ConstantSet.PASSWORD_REGEXP)
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

