package DP03_Factory.P02_SimpleFactory;

import DP03_Factory.base.IConfigParser;
import DP03_Factory.base.JsonConfigParserImpl;
import DP03_Factory.base.PropertiesConfigParserImpl;
import DP03_Factory.base.XmlConfigParserImpl;

/**
 * 功能说明：使用工厂创建需要的对象
 * 目的: 创建和使用解耦
 * <p>
 * <p>
 * 开发人员：@author MaLi
 */
public class ConfigParserFactory {
    //把noFactory里面的获取解析器代码部分, 原封不动拆分到独立的工厂类里面
    public IConfigParser getConfigParser(String ruleConfigFilePath) {
        String fileExtention = getFileExtention(ruleConfigFilePath);
        // 复杂的对象创建过程 -- 这种创建对象的代码和使用对象, 并没有关系
        IConfigParser parser;
        if ("json".equalsIgnoreCase(fileExtention)) {
            parser = new JsonConfigParserImpl();
        } else if ("properties".equalsIgnoreCase(fileExtention)) {
            parser = new PropertiesConfigParserImpl();
        } else if ("xml".equalsIgnoreCase(fileExtention)) {
            parser = new XmlConfigParserImpl();
        } else if ("ymal".equalsIgnoreCase(fileExtention)) {
            parser = new JsonConfigParserImpl();
            // 未来可能还会有更多的解析需求, 于是就在这里继续添加解析器创建代码... --
        } else {
            //使用运行时异常模拟一下自定义异常: 代表不支持的格式...
            throw new RuntimeException("File format not supported" + ruleConfigFilePath);
        }
        return parser;
    }

    // 模拟获取解析文件的扩展名
    public String getFileExtention(String ruleConfigFilePath) {
        return "JSON";
    }
}
