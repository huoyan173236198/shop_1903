package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Power;
import com.qf.serviceimpl.IPowerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/7/2 19:53
 */
@Controller
@RequestMapping("/power")
public class PowerController {
    @Reference
    private IPowerService powerService;

    @RequestMapping("/list")
    public String powerList(Model model){
        List<Power> powers=powerService.powerList();
        model.addAttribute("powers",powers);
        return "powerlist";
    }

    @RequestMapping("/insert")
    public String insert(Power power){
        powerService.insert(power);
        return "redirect:/power/list";
    }

    @ResponseBody
    @RequestMapping("/listajax")
    public List<Power> powerListAjax(){

        return powerService.powerList();
    }

    @RequestMapping("/queryPowersByRid")
    @ResponseBody
    public List<Power> queryPowersByRid(Integer rid){
        List<Power> powers=powerService.powerListByRid(rid);
        return powers;
    }
}
