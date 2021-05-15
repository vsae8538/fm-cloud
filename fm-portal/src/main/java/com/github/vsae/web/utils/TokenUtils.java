package com.github.vsae.web.utils;

import com.github.vsae.api.resource.model.TokenDTO;
import com.github.vsae.api.resource.utils.ConstantSet;
import com.github.vsae.api.resource.utils.Md5TokenGenerator;
import com.github.vsae.web.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenUtils {

    @Autowired
    Md5TokenGenerator tokenGenerator;

    @Autowired
    private RedisUtils redisUtils;

    public TokenDTO createToken(String email, String password, Integer customerId) {

        TokenDTO tokenDTO = new TokenDTO();

        String token = tokenGenerator.generate(email, password);
        redisUtils.set(token, email, ConstantSet.TOKEN_EXPIRE_TIME);
        redisUtils.set(AuthInterceptor.CUSTOMER_ID_KEY + email, token, ConstantSet.TOKEN_EXPIRE_TIME);

        tokenDTO.setToken(token);
        tokenDTO.setExpireTime(Long.valueOf(redisUtils.getExpire(token)));

        return tokenDTO;
    }
}
