package com.github.vsae.web.security.service.impl;


import com.github.vsae.api.resource.model.SecureUserDTO;
import com.github.vsae.api.resource.model.SecureUserResource;
import com.github.vsae.web.security.mapper.SecurityMapper;
import com.github.vsae.web.security.service.FmUserVerifiyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FmUserVerifiyServiceImpl implements FmUserVerifiyService {

    @Autowired
    SecurityMapper securityMapper;

    @Override
    public SecureUserDTO getUserSecureByUsername(String userName) {
        return securityMapper.getUserSecureByUserName(userName);
    }

    @Override
    public List<SecureUserResource> getUserSecureResourceByRoleName(String roleName){
        return securityMapper.getUserSecureResourceByLevel(roleName);
    }
}
