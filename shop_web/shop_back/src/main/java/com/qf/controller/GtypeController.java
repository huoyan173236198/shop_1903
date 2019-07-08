package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Gtype;
import com.qf.serviceimpl.IGtypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/7/6 14:29
 */
@Controller
@RequestMapping("/gtype")
public class GtypeController {

    @Reference
    private IGtypeService gtypeService;

    @RequestMapping("/list")
    public String queryList(Model model){
        List<Gtype> gtypes= gtypeService.queryGtypeList();
        model.addAttribute("gtypes",gtypes);
        return "gtypelist";
    }
    @RequestMapping("/insert")
    public String insertGtype(Gtype gtype){
        gtypeService.insertGtype(gtype);
        return "redirect:/gtype/list";
    }

    @RequestMapping("/listajax")
    @ResponseBody
    public List<Gtype> listajax(){
        return gtypeService.getList();
    }

}
