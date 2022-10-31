package com.example.first.controller;


import com.alibaba.fastjson.JSONArray;
import com.example.first.service.HospitalSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/index")
public class IndexController {


    @Resource
    HospitalSetService hospitalSetService;

    @RequestMapping("home")
    public String home(){
        return JSONArray.toJSONString(hospitalSetService.seleAll());
    }


}
