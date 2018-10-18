package com.example.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holleo")
public class HollerController {

    @Value("${your.name}")
    private  String yourName;

    @RequestMapping(value = "/index")
    public String index(ModelMap map){

        map.addAttribute("yourName","jjjjjj");
        return  "index";
    }
}
