package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.PowerMapper;
import com.qf.entity.Power;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/7/2 19:34
 */
@Service
public class PowerServiceImpl implements IPowerService{
    @Autowired
    private PowerMapper powerMapper;

    @Override
    public int insert(Power power) {
        return powerMapper.insert(power);
    }

    @Override
    public List<Power> powerList() {
        return powerMapper.queryAllPowers();
    }

    @Override
    public List<Power> powerListByRid(Integer rid) {

        return powerMapper.queryPowerByRid(rid);
    }
}
