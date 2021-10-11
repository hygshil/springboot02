package com.xiexin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/sessionList")
    public String studentList(){
        return "sessionlist";
    }
    @RequestMapping("/sysList")
    public String sysList(){
        return "syslist";
    }
}
