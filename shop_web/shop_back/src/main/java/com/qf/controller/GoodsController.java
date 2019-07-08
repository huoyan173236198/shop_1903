package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Goods;
import com.qf.serviceimpl.IGoodsService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/7/5 16:53
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Reference
    private IGoodsService goodsService;
    @Value("${upload.path}")
    private String uploadPath;
    @RequestMapping("/list")
    public String goodsList(Model model){
        List<Goods> goodsList=goodsService.queryGoodsList();

        model.addAttribute("goods",goodsList);
        return "goodslist";
    }

    @RequestMapping("/insert")
    public String insertGoods(Goods goods){
        goodsService.insertGoods(goods);
        return "redirect:/goods/list";
    }

    @RequestMapping("/uploadImg")
    @ResponseBody
    public String uploadImg(MultipartFile file){
        String uploadFile="";
        String originalFilename = file.getOriginalFilename();
        int index=originalFilename.lastIndexOf(".");
        String houzui=originalFilename.substring(index);
        String filename= UUID.randomUUID().toString()+houzui;
        uploadFile=uploadPath+filename;
        try (InputStream in=file.getInputStream();
             OutputStream out=new FileOutputStream(uploadFile);

        ){
            IOUtils.copy(in,out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{\"filepath\":\"" + uploadFile + "\"}";
    }

    @RequestMapping("/getImg")
    public void getImg(String imgpath, HttpServletResponse response){
        File file=new File(imgpath);
        try (
                InputStream in=new FileInputStream(file);
                OutputStream out=response.getOutputStream();
        ){
                IOUtils.copy(in,out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
