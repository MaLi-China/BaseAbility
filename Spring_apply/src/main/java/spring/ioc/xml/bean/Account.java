package spring.ioc.xml.bean;

import lombok.Data;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
@Data
public class Account {
    //普通数据类型
    private Integer id;
    private Float amount;

    public Account() {
    }

    public Account(Integer id, Float amount) {
        this.id = id;
        this.amount = amount;
    }
}
