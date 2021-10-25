package com.nengli51.facotry;

import com.nengli51.config.Configuration;
import org.dom4j.DocumentException;

import java.util.Map;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class ClasspathXmlApplicationContext implements BeanFactory {

    private Map<String, Object> container;
    private String cfgFilePath;


    public ClasspathXmlApplicationContext(String cfgFilePath) {
        this.cfgFilePath = cfgFilePath;
        try {
            container = Configuration.parse(cfgFilePath);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String id) {
        return container.get(id);
    }
}
