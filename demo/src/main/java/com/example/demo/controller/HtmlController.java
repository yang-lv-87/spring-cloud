package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html")
public class HtmlController {
	@Value("${vv}")
    private String vv; 
	
    @RequestMapping("/hello")
    public String hello(Model model) {
    	Date date = new Date();
        //获取配置文件中的信息vv
        System.out.println(vv);
        //传到template模板中（会把模板中能找到的所有的ftl文件中的名称都替换掉）
        model.addAttribute("vv", date.toString());

        return "template/hello";
    }
}