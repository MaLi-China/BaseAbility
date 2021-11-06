package com.nengli51.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
@Controller
@RequestMapping(value = "/welcome")
public class WelcomHandler {
    @RequestMapping(value = "/connect")
    public String testConnection() {
        return "success";
    }
}
