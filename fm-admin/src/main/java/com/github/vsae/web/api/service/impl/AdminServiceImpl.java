package com.github.vsae.web.api.service.impl;

import com.github.vsae.api.resource.excption.ResponseException;
import com.github.vsae.api.resource.model.User;
import com.github.vsae.api.resource.utils.BCryptPasswordEncoder;
import com.github.vsae.api.resource.utils.ConstantSet;
import com.github.vsae.api.resource.utils.Md5TokenGenerator;
import com.github.vsae.web.api.mapper.AdminMapper;
import com.github.vsae.web.api.service.AdminService;
import com.github.vsae.web.interceptor.AuthInterceptor;
import com.github.vsae.web.model.LoginParam;
import com.github.vsae.web.model.TokenResult;
import com.github.vsae.web.utils.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    Md5TokenGenerator tokenGenerator;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public TokenResult doLogin(LoginParam loginParam){
        String userName = loginParam.getUserName();
        String password = loginParam.getPassword();

        User user = adminMapper.getUserByUsername(userName);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        logger.info("user login: " + userName);

        if(user != null && encoder.matches(password, user.getPassword())){
            String token = (String) redisUtils.get(AuthInterceptor.ADMIN_ID_KEY + String.valueOf(user.getSeqno()));
            if(StringUtils.isNotBlank(token)){
                logout(token);
                logger.info("Repeat login userName : {}", user.getUserName());
            }

            return createToken(user.getUserName(), user.getPassword(), user.getSeqno());
        }

        return new TokenResult();
    }

    @Override
    public void logout(String token) {

        String adminId = (String) redisUtils.get(token);
        redisUtils.del(token);
        redisUtils.del(AuthInterceptor.ADMIN_ID_KEY + adminId);

        logger.info("user logout token: " + token);
    }

    private TokenResult createToken(String userName, String password, Integer adminId) {

        TokenResult tokenResult = new TokenResult();

        String token = tokenGenerator.generate(userName, password);
        redisUtils.set(token, adminId, ConstantSet.TOKEN_EXPIRE_TIME);
        redisUtils.set(AuthInterceptor.ADMIN_ID_KEY + adminId, token, ConstantSet.TOKEN_EXPIRE_TIME);

        tokenResult.setToken(token);
        tokenResult.setExpireTime(Long.valueOf(redisUtils.getExpire(token)));

        return tokenResult;
    }
}
