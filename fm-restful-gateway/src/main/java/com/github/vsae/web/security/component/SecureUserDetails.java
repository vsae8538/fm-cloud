package com.github.vsae.web.security.component;


import com.github.vsae.api.resource.model.SecureUserDTO;
import com.github.vsae.api.resource.model.SecureUserResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class SecureUserDetails implements UserDetails {

    private SecureUserDTO secureUserDTO;

    private List<SecureUserResource> resourceList;

    public SecureUserDetails(SecureUserDTO secureUserDTO, List<SecureUserResource> resourceList) {
        this.secureUserDTO = secureUserDTO;
        this.resourceList = resourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的角色
        return resourceList.stream()
                .map(role ->new SimpleGrantedAuthority(role.getSeqno()+":"+role.getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return secureUserDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return secureUserDTO.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return secureUserDTO.getStatus().equals(1);
    }
}
