package com.github.vsae.web.api.service.impl;

import com.github.vsae.api.resource.excption.ResponseException;
import com.github.vsae.api.resource.http.ResponseCode;
import com.github.vsae.web.api.mapper.ProductMapper;
import com.github.vsae.web.api.service.HomePageService;
import com.github.vsae.web.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<HomePageTrendingProducts> getTrendingProductsByTop(TrendingProductsParam trendingProductsParam){
        int top = trendingProductsParam.getTop();
        List<HomePageTrendingProducts> homePageTrendingProducts = productMapper.getTrendingProductByTop(top);
        if(null == homePageTrendingProducts){
            throw new ResponseException(ResponseCode.TRENDING_PRODUCT_IS_EMPTY,
                    ResponseCode.TRENDING_PRODUCT_IS_EMPTY.getMessage());
        }
        return homePageTrendingProducts;
    }

    @Override
    public List<HomePageLastestProducts> getLastestProductByTop(LastestProductsParam lastestProductsParam) {
        int top = lastestProductsParam.getTop();
        List<HomePageLastestProducts> homePageLastestProducts = productMapper.getLastestProductByTop(top);
        if(null == homePageLastestProducts){
            throw  new ResponseException(ResponseCode.LASTEST_PRODUCT_IS_EMPTY,
                    ResponseCode.LASTEST_PRODUCT_IS_EMPTY.getMessage());
        }
        return homePageLastestProducts;
    }

    @Override
    public List<HomePageBestProducts> getBestProductByTop(BestProductsParam bestProductsParam) {
        int top = bestProductsParam.getTop();
        List<HomePageBestProducts> homePageBestProducts = productMapper.getBestProductByTop(top);
        if(null == homePageBestProducts){
            throw new ResponseException(ResponseCode.BEST_PRODUCT_IS_EMPTY,
                    ResponseCode.BEST_PRODUCT_IS_EMPTY.getMessage());
        }
        return homePageBestProducts;
    }


}
