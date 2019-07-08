package com.qf.serviceimpl;

import com.qf.entity.Role;

import java.util.List;

public interface IRoleService {
    List<Role> roleList();
    int insertRole(Role role);
    List<Role> roleListByUid(Integer uid);
    int updateRolePowers(Integer rid,Integer[] pids);
}
