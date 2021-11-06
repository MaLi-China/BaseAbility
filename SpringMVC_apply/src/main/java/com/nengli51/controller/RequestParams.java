package com.nengli51.controller;

import com.nengli51.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

/**
 * 功能说明：测试获取请求参数
 * 1, 简单数据类型
 * 2, 包装数据类型
 * 3, 日期
 * 开发人员：@author MaLi
 */
@Controller
@RequestMapping(value = "/param")
public class RequestParams {
    private Integer id;

    @RequestMapping(value = "/get1")
    public String getParam1(String id, String name, Map<String, Object> map) {
        map.put("id", id);
        map.put("name", name);
        return "success";
    }

    @RequestMapping(value = "/get2")
    public String getParam2(Person person, Map<String, Object> map) {
        map.put("person", person);
        return "success";
    }

    @RequestMapping(value = "/get3")
    public String getParam3(@RequestParam("idplus") Integer id, String name, Date birthday, Map<String, Object> map) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setBirthday(birthday);
        map.put("person", person);
        return "success";
    }

    @RequestMapping(value = "/get4")
    public String getParam4(@RequestParam("idplus") Person person, Map<String, Object> map) {
        map.put("person", person);
        return "success";
    }
}
