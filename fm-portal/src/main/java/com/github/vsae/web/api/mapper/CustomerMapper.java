package com.github.vsae.web.api.mapper;

import com.github.vsae.api.resource.model.Customer;
import com.github.vsae.api.resource.model.User;
import com.github.vsae.web.model.CustomerSignUpParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerMapper {

    @Select("SELECT c.seqno, c.first_name, c.password, c.last_name, c.address, c.city, c.email, c.cust_level, c.telephone " +
            "FROM customer c " +
            "WHERE c.email = #{email} ")
    public Customer getCustomerByEmail(String email);


    @Insert("INSERT INTO customer( " +
            "first_name, last_name, email, password, " +
            "create_id, create_date, update_id, update_date) " +
            "VALUES(#{firstName}, #{lastName}, #{email}, #{password}, " +
            "'portal', SYSDATE(), 'portal', SYSDATE()) "
    )
    public int insertCustomer(Customer customer);

}
