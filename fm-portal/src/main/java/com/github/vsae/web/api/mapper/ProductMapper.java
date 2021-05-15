package com.github.vsae.web.api.mapper;

import com.github.vsae.web.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT p.seqno, p.image, p.product_name, p.price, p.rate " +
            "FROM product p " +
            "ORDER BY p.sales_count DESC " +
            "LIMIT #{top} ")
    public List<HomePageTrendingProducts> getTrendingProductByTop(int top);

    @Select("SELECT p.seqno, p.image, p.product_name, p.price, p.rate " +
            "FROM product p " +
            "ORDER BY p.publish_date DESC " +
            "LIMIT #{top} ")
    public List<HomePageLastestProducts> getLastestProductByTop(int top);

    @Select("SELECT p.seqno, p.image, p.product_name, p.price, p.rate " +
            "FROM product p " +
            "ORDER BY p.rate DESC " +
            "LIMIT #{top} ")
    public List<HomePageBestProducts> getBestProductByTop(int top);


    @Select("SELECT p.seqno, p.image, p.product_name, p.price, p.rate, p.rate_count, p.product_sn, v.vendor_name, " +
                "p.stock, p.product_type, p.color, p.size, p.images " +
            "FROM product p " +
            "LEFT JOIN vendor v ON (p.vendor_seqno = v.seqno) " +
            "WHERE p.seqno = #{seqno} ")
    Product getProductDetailBySeqno(int seqno);

//    SELECT p.seqno, p.productName, p.productSn, p.price,
//    p.rate, p.rate_count, p.stock, p.product_type, p.color,
//    p.size, p.images
//    FROM product p
//    LEFT JOIN product_category pc ON (pc.seqno =  p.product_category_seqno)
//    LEFT JOIN product_brand pb ON (pb.seqno = p.banrd_seqno)
//    WHERE (OM.ORDER_NO LIKE :SALEORDER_ORDER_NO OR :SALEORDER_ORDER_NO IS NULL)
//    AND (OM.STATUS like :STATUS OR :STATUS IS NULL)
    List<Product> getProducts(GetProductsParam getProductsParam);

}
