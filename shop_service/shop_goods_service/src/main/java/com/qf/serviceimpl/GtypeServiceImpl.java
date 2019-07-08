package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.GtypeMapper;
import com.qf.entity.Gtype;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/7/6 14:26
 */
@Service
public class GtypeServiceImpl implements IGtypeService{

    @Autowired
    private GtypeMapper gtypeMapper;

    @Override
    public List<Gtype> queryGtypeList() {
        return gtypeMapper.queryAllGtypes();
    }

    @Override
    public Gtype insertGtype(Gtype gtype) {
        gtypeMapper.insert(gtype);
        return gtype;
    }

    @Override
    public List<Gtype> getList() {
        return gtypeMapper.selectList(null);
    }
}
