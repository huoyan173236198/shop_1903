package com.qf.serviceimpl;

import com.qf.entity.Gtype;

import java.util.List;

public interface IGtypeService {
    List<Gtype> queryGtypeList();
    Gtype insertGtype(Gtype gtype);
    List<Gtype> getList();
}
