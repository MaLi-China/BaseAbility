package com.nengli51.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 功能说明：测试SpringMVC对RESTful的增删改查
 * 开发人员：@author MaLi
 */
@Controller
@RequestMapping("/demo")
public class RESTfulHandler {
    @RequestMapping(value = "/handle/{id}", method = RequestMethod.GET)
    public void doAction1(@PathVariable("id") Integer id) {
        System.out.println("Get请求: " + id);
    }

    @RequestMapping(value = "/handle", method = RequestMethod.POST)
    public void doAction2(String username) {
        System.out.println("POST请求: " + username);
    }

    @RequestMapping(value = "/handle/{id}/{username}", method = RequestMethod.PUT)
    public void doAction3(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        System.out.println("PUT请求: ID: " + id + " UserName: " + username);
    }

    @RequestMapping(value = "/handle/{id}", method = RequestMethod.DELETE)
    public void doAction4(@PathVariable("id") Integer id) {
        System.out.println("DELETE请求: ID: " + id);
    }
}
