package com.nengli51.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
@Data
public class Orders {
    private Integer oid;
    private Date orderDate;
    private Integer uid;
    private List<User> users;
}
