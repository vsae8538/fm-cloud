package com.github.vsae.web.api.mapper;

import com.github.vsae.api.resource.model.SecureUserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VerifyMapper {

    @Select("SELECT u.seqno, u.password, u.status, r.role_name AS roleName, r.level " +
            "FROM user u " +
            "INNER JOIN role r ON (u.role_seqno = r.seqno) " +
            "WHERE u.user_name = #{userName} ")
    SecureUserDTO getSecureUserByUserName(@Param(value = "userName") String userName);

}
