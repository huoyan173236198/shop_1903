package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Role;
import com.qf.serviceimpl.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/7/2 17:28
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Reference
    private IRoleService roleService;

    @RequestMapping("/list")
    public String roleList(Model model){
        List<Role> roles=roleService.roleList();
        model.addAttribute("roles",roles);
        return "rolelist";
    }

    @RequestMapping("/insert")
    public String roleInsert(Role role){
        roleService.insertRole(role);
        return "redirect:/role/list";
    }

    @RequestMapping("/listajax")
    @ResponseBody
    public List<Role> roleListAjax(Integer uid){
        List<Role> roles= roleService.roleListByUid(uid);
        return roles;
    }

    @RequestMapping("/updatePower")
    @ResponseBody
    public String updatePower(Integer rid,@RequestParam("pids[]") Integer[] pids){
        roleService.updateRolePowers(rid,pids);
        return "succ";
    }

}
