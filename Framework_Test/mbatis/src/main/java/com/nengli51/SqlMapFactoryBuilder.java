package com.nengli51;

import com.nengli51.config.XMLConfigBuilder;
import com.nengli51.io.Resources;
import com.nengli51.pojo.Configuration;
import org.dom4j.DocumentException;

import java.io.InputStream;

/**
 * 功能说明：解析配置文件, 创建SqlMapFactory
 * 开发人员：@Author MaLi
 */
public class SqlMapFactoryBuilder {
    public SqlMapFactory build(String path) throws DocumentException {
        InputStream inputStream = Resources.loadConfig(path);
        Configuration configuration = XMLConfigBuilder.parse(inputStream);
        return null;
    }
}
