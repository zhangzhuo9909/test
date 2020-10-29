package org.zhangzhuo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.zhangzhuo.entity.IndexRoll;

import java.util.List;

/**
 * <p>
 * 首页轮播图 服务类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
public interface IndexRollService extends IService<IndexRoll> {

    //查询列表
    List<IndexRoll> getIndexRoll();
    //添加轮训图的内容
    void getSaveIndexRoll(IndexRoll indexRoll);
    //修改轮训图的内容
    void getUpdateIndexRoll(IndexRoll indexRoll);
    //删除
    void getRemoveIndexRoll(Long id);
}
