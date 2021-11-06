package com.nengli51.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
@Controller
@RequestMapping(value = "/returnValue")
public class ReturnValueHandler {
    @RequestMapping(value = "/doAction1")
    public ModelAndView doAction1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("date1", new Date());
        return modelAndView;
    }


    @RequestMapping(value = "/doAction2")
    public ModelAndView doAction2(Map<String, Object> map) {
        map.put("date2", new Date());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("date", new Date());
        return modelAndView;
    }

    @RequestMapping(value = "/doAction3")
    public ModelAndView doAction3(ModelMap map) {
        map.put("date3", new Date());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("date", new Date());
        return modelAndView;
    }

    @RequestMapping(value = "/doAction4")
    public ModelAndView doAction4(Model model) {
        model.addAttribute("date4", new Date());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("date", new Date());
        return modelAndView;
    }
}
