package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.BackUser;
import com.qf.serviceimpl.IBackUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/7/2 12:15
 */
@Controller
@RequestMapping("/buser")
public class BackUserController {
    @Reference
    private IBackUserService backUserService;


    @RequestMapping("/list")
    public String userList(Model model){
        List<BackUser> backUsers = backUserService.queryAll();
        model.addAttribute("users", backUsers);
        return "buserlist";
    }


    @RequestMapping("/insert")
    public String userAdd(BackUser backUser){
        backUserService.insertUser(backUser);
        return "redirect:/buser/list";
    }

    @RequestMapping("/updaterole")
    public String updateUserRole(Integer uid, Integer[] rid){

        backUserService.updateUserRoles(uid, rid);

        return "redirect:/buser/list";
    }
}
