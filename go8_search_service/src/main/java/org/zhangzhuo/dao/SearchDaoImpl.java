package org.zhangzhuo.dao;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zhangzhuo.config.SearchResult;
import org.zhangzhuo.pojo.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SearchDaoImpl implements  SearchDao{
    @Autowired
    private Client client;

    /**
     * 添加一个文档
     * @param product
     * @return
     */
    @Override
    public IndexResponse index(Product product) {
        try {
            XContentBuilder field = XContentFactory.jsonBuilder().startObject()
                    .field("id", product.getId())
                    .field("picture", product.getPicture())
                    .field("catalog_name",product.getCatalog_name() )
                    .field("attribute", product.getAttributes())
                    .field("brand_cname", product.getBrand_cname())
                    .field("brand_ename", product.getBrand_ename())
                    .field("image", product.getImage())
                    .field("price", product.getPrice())
                    .field("title", product.getTitle()).endObject();

            IndexResponse indexResponse = client.prepareIndex().setIndex("goods").setType("_doc")
                    .setId(new Long(product.getId()).toString()).setSource(field).get();
            return indexResponse;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 安装传入的条件进查询es
     * @param q
     * @param page
     * @param size
     * @return
     */
    @Override
    public SearchResult<Product> queryMath(String q, int page, int size) {
        //创建一个对象
        SearchResult<Product> searchResult = new SearchResult<>();
        //获取查询的内容
            SearchResponse search = client.prepareSearch()
                    .setIndices("goods")//索引
                    .setQuery(
                            QueryBuilders.multiMatchQuery(
                                    q,"catalog_name","attributes","title"))//建造者模式多字段查询
                    .setFrom((page - 1) * size)//偏移量 默认 (page - 1) * size
                    .setSize(size)//每页的大小
                    .setFetchSource(

                            new String[] { "id","title","picture","price" },null)//获取数据源
                    //高亮
                    .highlighter(new HighlightBuilder().field("title")
                            .preTags("<span style=\"color:red\">")
                            .postTags("</span>"))
                    //执行方法
                    .execute().actionGet();
            //获取第一个hit
        SearchHits searchHits = search.getHits();
        //获取hit里面的hit,也就是数据
        SearchHit[] hits = searchHits.getHits();
        //创建一个list集合用来存放数据
        List<Product> list = new ArrayList<Product>();
        //将数据遍历出来
        for (int i = 0;i<hits.length;i++){
            //获取每一个数据
            SearchHit hit  = hits[i];
            //将获取的数据放进map里面
            Map<String, Object> map = hit.getSourceAsMap();
            //创建一个goods对象 并开始赋值
            Product goods = new Product();
            //给id赋值
            goods.setId(Long.parseLong(map.get("id").toString()));
            //给图片赋值
            goods.setPicture(map.get("picture").toString());
            //给价格赋值
            goods.setPrice((int) map.get("price"));

            //获取高亮的所有字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            //通过键获取高亮title的字段
            HighlightField title = highlightFields.get("title");
            //如果存在要高亮的内容
            if(title != null && title.getFragments()!= null){
                //获取高亮的内容
                Text[] fragments = title.getFragments();
                goods.setTitle(fragments[0].toString());
            }else {
                //不存在就 存进title字段
                goods.setTitle((String)map.get("title"));
            }
            //添加进集合
            list.add(goods);
        }
        //赋值
        searchResult.setData(list);
        searchResult.setTotal(searchHits.getTotalHits());
        searchResult.setPage(page);
        searchResult.setSize(size);
        //返回结果
        return searchResult;
    }

//    @Override
//    public SearchResult<Product> queryKeyWord(String k, int page, int size) {
//        return null;
//    }
}
