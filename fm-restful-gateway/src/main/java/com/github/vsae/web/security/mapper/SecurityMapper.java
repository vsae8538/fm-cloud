package com.github.vsae.web.security.mapper;

import com.github.vsae.api.resource.model.SecureUserDTO;
import com.github.vsae.api.resource.model.SecureUserResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SecurityMapper {

    @Select("SELECT u.seqno, u.user_name, u.password, u.status, r.role_name AS roleName, r.level " +
            "FROM user u " +
            "INNER JOIN role r ON (u.role_seqno = r.seqno) " +
            "WHERE u.user_name = #{userName} ")
    SecureUserDTO getUserSecureByUserName(@Param(value = "userName") String userName);

    @Select("SELECT ur.seqno, ur.role_name, ur.resource_url as url " +
            "FROM url_resource ur " +
            "INNER JOIN role r ON (ur.role_name = r.role_name) " +
            "WHERE ur.role_name = #{roleName} ")
    List<SecureUserResource> getUserSecureResourceByLevel(@Param(value = "roleName") String roleName);

}
