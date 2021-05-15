package com.github.vsae.web.api.service.impl;

import com.github.vsae.api.resource.model.PageData;
import com.github.vsae.web.api.mapper.ProductMapper;
import com.github.vsae.web.api.service.ProductService;
import com.github.vsae.web.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<HomePageTrendingProducts> getTrendingProductByTop(int top) {
        return productMapper.getTrendingProductByTop(top);
    }

    @Override
    public List<HomePageLastestProducts> getLastestProductByTop(int top) {
        return productMapper.getLastestProductByTop(top);
    }

    @Override
    public List<HomePageBestProducts> getBestProductByTop(int top) {
        return productMapper.getBestProductByTop(top);
    }

    @Override
    public Product getProductDetailBySeqno(int seqno) {
        return productMapper.getProductDetailBySeqno(seqno);
    }

    @Override
    public PageData getProducts(GetProductsParam getProductsParam) {
        return null;
    }

}
