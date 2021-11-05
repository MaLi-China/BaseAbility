package com.nengli51.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/hello/sayHello")
    public ModelAndView sayHello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("date", new Date());
        modelAndView.setViewName("success");
        System.out.println("HelloController 的 sayHello 方法执行了。。。。 ");
        return modelAndView;
    }
}
