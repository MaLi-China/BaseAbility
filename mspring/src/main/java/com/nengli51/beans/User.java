package com.nengli51.beans;

import lombok.Data;

import java.util.Date;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String gender;
    private Date birthday;
    private String address;
}
