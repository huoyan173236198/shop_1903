package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.dao.RoleMapper;
import com.qf.dao.RolePowerMapper;
import com.qf.entity.Role;
import com.qf.entity.RolePowerTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/7/2 16:50
 */
@Service
public class RoleServiceImpl implements IRoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePowerMapper rolePowerMapper;

    @Override
    public List<Role> roleList() {
        return roleMapper.selectList(null);
    }

    @Override
    public int insertRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public List<Role> roleListByUid(Integer uid) {

        return roleMapper.queryListByUid(uid);
    }

    @Override
    @Transactional
    public int updateRolePowers(Integer rid, Integer[] pids) {
        QueryWrapper<RolePowerTable> query=new QueryWrapper<>();
        query.eq("rid",rid);
        rolePowerMapper.delete(query);

        for(Integer pid :pids){
            RolePowerTable rolePowerTable=new RolePowerTable(rid,pid);
            rolePowerMapper.insert(rolePowerTable);
        }
        return 1;
    }
}
