package com.nengli51.pojo;

import java.util.Date;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Person {
    private Integer id;
    private String name;
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
