package com.how2java.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//专用于页面跳转
@Controller
public class AdminPageController {
    //控制跳转
    @GetMapping(value = "/admin")
    public String admin(){return "redirect:admin_category_list";}
    //去取对应HTML文件
    @GetMapping(value ="/admin_category_list" )
    public String listCategory(){return "admin/listCategory";}
    //编辑功能，增加对listCateogry.html超链的映射
    @GetMapping(value="/admin_category_edit")
    public String editCategory(){
        return "admin/editCategory";

    }
}
