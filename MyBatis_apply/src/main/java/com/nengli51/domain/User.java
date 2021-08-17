package com.nengli51.domain;

import lombok.Data;

import java.sql.Date;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */

@Data
public class User {
    private Integer uid;
    private String username;
    private String sex;
    private Date birthday;
    private String address;
}
