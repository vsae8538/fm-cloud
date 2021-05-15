package com.github.vsae.web.model;


import com.github.vsae.api.resource.utils.ConstantSet;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerLoginParam {

    @NotNull
    @Pattern(regexp = ConstantSet.EMAIL_REGEXP)
    @ApiModelProperty(example = "email", required = true)
    private String email;

    @NotNull
    @Pattern(regexp = ConstantSet.PASSWORD_REGEXP)
    @ApiModelProperty(example = "password", required = true)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

