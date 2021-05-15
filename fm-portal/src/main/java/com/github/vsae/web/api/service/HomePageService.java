package com.github.vsae.web.api.service;

import com.github.vsae.web.model.*;

import java.util.List;

public interface HomePageService {

    public List<HomePageTrendingProducts> getTrendingProductsByTop(TrendingProductsParam productsParam);

    public List<HomePageLastestProducts> getLastestProductByTop(LastestProductsParam lastestProductsParam);

    public List<HomePageBestProducts> getBestProductByTop(BestProductsParam BestProductsParam);
}
