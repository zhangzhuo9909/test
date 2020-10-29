package org.zhangzhuo.dao;

import org.elasticsearch.action.index.IndexResponse;
import org.zhangzhuo.config.SearchResult;
import org.zhangzhuo.pojo.Product;

public interface SearchDao {
    IndexResponse index(Product product);

    SearchResult<Product> queryMath(String q, int page, int size);

//    SearchResult<Product> queryKeyWord(String k,int page, int size);
}
