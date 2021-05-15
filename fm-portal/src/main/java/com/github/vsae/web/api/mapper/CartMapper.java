package com.github.vsae.web.api.mapper;

import com.github.vsae.web.model.CartProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CartMapper {

    @Select("SELECT p.product_name, p.price,p.color, p.size " +
            "FROM product p " +
            "WHERE p.seqno = #{seqno} ")
    public CartProductDetail getCartProductDetailBySeqno(Integer seqno);

}
