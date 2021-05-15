package com.github.vsae.web.api.service;

import com.github.vsae.web.model.JWTLoginParam;

public interface VerifyService {

    public String doLogin(JWTLoginParam jwtLoginParam);

}
