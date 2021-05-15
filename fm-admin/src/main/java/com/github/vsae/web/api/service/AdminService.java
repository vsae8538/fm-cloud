package com.github.vsae.web.api.service;

import com.github.vsae.web.model.LoginParam;
import com.github.vsae.web.model.TokenResult;

public interface AdminService {
    public TokenResult doLogin(LoginParam hrLoginVO);
    public void logout(String token);
}
