package org.zhangzhuo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zhangzhuo.entity.IndexRoll;
import org.zhangzhuo.mapper.IndexRollMapper;
import org.zhangzhuo.service.IndexRollService;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 首页轮播图 服务实现类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Service
public class IndexRollServiceImpl extends ServiceImpl<IndexRollMapper, IndexRoll> implements IndexRollService {

    /**
     * 查询实现类
     * @return
     */
    @Override
    public List<IndexRoll> getIndexRoll() {
        //无业务逻辑 直接查询列表
        List<IndexRoll> list = list();
        //
        return list;
    }

    /**
     * 添加方法实现类
     * @param indexRoll
     */
    @Override
    public void getSaveIndexRoll(IndexRoll indexRoll) {
        //设置创建的时间
        indexRoll.setGmtCreate(new Date());
        //设置修改的时间
        indexRoll.setGmtModified(new Date());
        //执行添加
        save(indexRoll);
    }

    /**
     * 修改方法的实现
     * @param indexRoll
     */
    @Override
    public void getUpdateIndexRoll(IndexRoll indexRoll) {
        //修改后自定设置时间
        indexRoll.setGmtModified(new Date());
        //执行修改
        updateById(indexRoll);
    }

    /**
     * 删除的实现类
     * @param id
     */
    @Override
    public void getRemoveIndexRoll(Long id) {
        removeById(id);
    }
}
