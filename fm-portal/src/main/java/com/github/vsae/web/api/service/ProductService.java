package com.github.vsae.web.api.service;

import com.github.vsae.api.resource.model.PageData;
import com.github.vsae.web.model.*;

import java.util.List;

public interface ProductService {

    public List<HomePageTrendingProducts> getTrendingProductByTop(int top);

    public List<HomePageLastestProducts> getLastestProductByTop(int top);

    public List<HomePageBestProducts> getBestProductByTop(int top);

    public Product getProductDetailBySeqno(int seqno);

    public PageData getProducts(GetProductsParam getProductsParam);
}
