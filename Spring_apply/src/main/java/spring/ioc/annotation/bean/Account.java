package spring.ioc.annotation.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
@Data
public class Account {
    String xx = ";";
    //普通数据类型
    private Integer id;
    private Float amount;
    //集合数据类型
    private Properties aProp;
    private Map<String, Object> aMap;
    private String[] aString;
    private List<Object> aList;
    private Set<Object> aSet;


}
