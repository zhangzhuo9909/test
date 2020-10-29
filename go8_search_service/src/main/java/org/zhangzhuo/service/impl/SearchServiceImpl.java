package org.zhangzhuo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhangzhuo.config.SearchResult;
import org.zhangzhuo.dao.SearchDao;
import org.zhangzhuo.pojo.Product;
import org.zhangzhuo.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
    private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);
    @Autowired
    private SearchDao searchDao;

    @Override
    public void index(Product product) {
        try {
            searchDao.index(product);
        } catch (Exception e) {
            logger.error("----look here please------->"+product,e);
        }
    }

    @Override
    public SearchResult<Product> queryMath(String q, int page, int size) {
        return searchDao.queryMath(q,page,size);
    }
}
