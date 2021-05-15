package com.github.vsae.web.security.service;


import com.github.vsae.api.resource.model.SecureUserDTO;
import com.github.vsae.api.resource.model.SecureUserResource;

import java.util.List;

public interface FmUserVerifiyService {

    public SecureUserDTO getUserSecureByUsername(String userName);

    public List<SecureUserResource> getUserSecureResourceByRoleName(String roleName);
}
