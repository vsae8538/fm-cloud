package com.github.vsae.web.api.service.impl;

import com.github.vsae.api.resource.excption.ResponseException;
import com.github.vsae.api.resource.model.SecureUserDTO;
import com.github.vsae.api.resource.model.SecureUserResource;
import com.github.vsae.web.api.mapper.VerifyMapper;
import com.github.vsae.web.api.service.VerifyService;
import com.github.vsae.web.model.JWTLoginParam;
import com.github.vsae.web.security.component.SecureUserDetails;
import com.github.vsae.web.security.service.FmUserVerifiyService;
import com.github.vsae.web.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerifyServiceImpl implements VerifyService {

    private static final Logger log = LoggerFactory.getLogger(VerifyServiceImpl.class);

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerifyMapper verifyMapper;

    @Autowired
    private FmUserVerifiyService fmUserVerifiyService;

    @Override
    public String doLogin(JWTLoginParam jwtLoginParam) {
        String token = null;
        String userName = jwtLoginParam.getUsername();
        String password = jwtLoginParam.getPassword();

        SecureUserDTO secureUserDTO = fmUserVerifiyService.getUserSecureByUsername(userName);

        if(secureUserDTO == null || !passwordEncoder.matches(password, secureUserDTO.getPassword())){
            throw new ResponseException("The admin user not exists or password failed.");
        }

        List<SecureUserResource> permissionList = fmUserVerifiyService.getUserSecureResourceByRoleName(secureUserDTO.getRoleName());
        UserDetails userDetails = new SecureUserDetails(secureUserDTO, permissionList);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        token = jwtTokenUtil.generateToken(userDetails);

        return token;
    }
}
