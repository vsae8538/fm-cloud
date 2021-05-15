package com.github.vsae.web.api.mapper;

import com.github.vsae.api.resource.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {

    @Select("SELECT u.seqno, u.user_name AS userName, u.password, u.status, r.role_name AS roleName, r.level " +
            "FROM user u " +
            "INNER JOIN role r ON (u.role_seqno = r.seqno) " +
            "WHERE u.user_name = #{userName} ")
    public User getUserByUsername(String userName);

}
