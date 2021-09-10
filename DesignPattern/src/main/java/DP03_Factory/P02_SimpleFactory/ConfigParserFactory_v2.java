package DP03_Factory.P02_SimpleFactory;

import DP03_Factory.base.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能说明：使用工厂创建需要的对象
 * 目的: 创建和使用解耦
 * <p>
 * <p>
 * 开发人员：@author MaLi
 */
public class ConfigParserFactory_v2 {
    private Map<String, IConfigParser> configParserMap = new HashMap<>();

    public ConfigParserFactory_v2() {
        configParserMap.put("json", new JsonConfigParserImpl());
        configParserMap.put("properties", new PropertiesConfigParserImpl());
        configParserMap.put("xml", new XmlConfigParserImpl());
        configParserMap.put("ymal", new YamlConfigParserImpl());
    }

    //v1版本, 每次获取都要重新创建Parser, v2版本采用缓存的方式,
    public IConfigParser getConfigParser(String ruleConfigFilePath) {
        String fileExtention = getFileExtention(ruleConfigFilePath);
        return configParserMap.get(fileExtention.toLowerCase());
    }

    // 模拟获取解析文件的扩展名
    public String getFileExtention(String ruleConfigFilePath) {
        return "JSON";
    }
}
