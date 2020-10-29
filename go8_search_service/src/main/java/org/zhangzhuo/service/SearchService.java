package org.zhangzhuo.service;

import org.zhangzhuo.config.SearchResult;
import org.zhangzhuo.pojo.Product;

public interface SearchService {
    void index(Product product);

    SearchResult<Product> queryMath(String q,int page,int size);

}
