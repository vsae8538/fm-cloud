package com.github.vsae.web.api.service;

import com.github.vsae.api.resource.model.LoginResult;
import com.github.vsae.api.resource.model.RegisterResult;
import com.github.vsae.api.resource.model.TokenDTO;
import com.github.vsae.web.model.CustomerLoginParam;
import com.github.vsae.web.model.CustomerSignUpParam;

public interface CustomerService {

    public LoginResult doLogin(CustomerLoginParam hrLoginVO);

    public void logout(String token);

    public RegisterResult doRegister(CustomerSignUpParam customerSignUpParam);

}
