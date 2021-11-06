package com.nengli51.controller;

import com.nengli51.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
@Controller
@RequestMapping(value = "/ajax")
public class AjaxHandler {
    @RequestMapping(value = "/doAction")
    public @ResponseBody
    Person doAction(@RequestBody Person person) {
        System.out.println("Ajax: " + person);
        return person;
    }
}
