package com.qf.serviceimpl;

import com.qf.entity.Power;

import java.util.List;

public interface IPowerService {
    int insert(Power power);
    List<Power> powerList();
    List<Power> powerListByRid(Integer rid);
}
