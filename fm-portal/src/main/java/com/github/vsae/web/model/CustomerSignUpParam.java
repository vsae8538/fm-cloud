package com.github.vsae.web.model;

import com.github.vsae.api.resource.utils.ConstantSet;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerSignUpParam {

    @NotNull
    @ApiModelProperty(example = "first name", required = true)
    private String firstName;

    @NotNull
    @ApiModelProperty(example = "last name", required = true)
    private String lastName;

    @NotNull
    @ApiModelProperty(example = "email", required = true)
    @Pattern(regexp = ConstantSet.EMAIL_REGEXP)
    private String email;

    @NotNull
    @ApiModelProperty(example = "password", required = true)
    @Pattern(regexp = ConstantSet.PASSWORD_REGEXP)
    private String password;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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
