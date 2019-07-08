package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.dao.BackUserMapper;
import com.qf.dao.UserRoleMapper;
import com.qf.entity.BackUser;
import com.qf.entity.UserRoleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/7/2 12:05
 */
@Service
public class BackUserServiceImpl implements IBackUserService{

    @Autowired
    private BackUserMapper backUserMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public List<BackUser> queryAll() {
        return backUserMapper.selectList(null);
    }

    @Override
    public int insertUser(BackUser backUser) {
        return backUserMapper.insert(backUser);
    }

    @Override
    @Transactional
    public int updateUserRoles(Integer uid, Integer[] rid) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("uid",uid);
        userRoleMapper.delete(queryWrapper);

        for(Integer roleid:rid){
            UserRoleTable userRoleTable=new UserRoleTable(uid,roleid);
            userRoleMapper.insert(userRoleTable);
        }
        return 1;
    }

    /*@Override
    public BackUser login(String username, String password) {
        BackUser backUser=backUserMapper.queryByUserName(username);
        if(backUser!=null&&backUser.getPassword().equals(password)){
            return backUser;
        }
        return null;
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BackUser backUser=backUserMapper.queryByUserName(username);
        if(backUser==null){
            throw new UsernameNotFoundException("该用户不存在");
        }

        return backUser;
    }
}
