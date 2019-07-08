package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.GoodsMapper;
import com.qf.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/7/5 17:26
 */
@Service
public class GoodsServiceImpl implements IGoodsService{
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> queryGoodsList() {
        return goodsMapper.selectList(null);
    }

    @Override
    public Goods insertGoods(Goods goods) {
         goodsMapper.insert(goods);
         return goods;
    }
}
