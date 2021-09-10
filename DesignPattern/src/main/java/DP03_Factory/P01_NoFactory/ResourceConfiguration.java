package DP03_Factory.P01_NoFactory;

import DP03_Factory.base.*;

import java.io.File;

/**
 * 功能说明：模拟在客户端创建复杂对象
 * 代码问题:
 * -复杂的对象创建过程掺杂在客户端(或者叫使用该对象的地方)带来两个问题
 * 1, 创建过程很复杂, 且需求变化较多 - 不满足开闭原则
 * 2, 创建代码和使用代码耦合在一起 - 不满足单一职责
 * 解决办法:
 * -使用工厂解决 - 买车直接去汽车厂就好了, 没有必要自己造
 * <p>
 * <p>
 * 开发人员：@author MaLi
 */
public class ResourceConfiguration {
    public Config load(String ruleConfigFilePath) {
        String extention = getFileExtention(ruleConfigFilePath);
        // 复杂的对象创建过程 -- 这种创建对象的代码和使用对象, 并没有关系
        IConfigParser parser;
        if ("json".equalsIgnoreCase(extention)) {
            parser = new JsonConfigParserImpl();
        } else if ("properties".equalsIgnoreCase(extention)) {
            parser = new PropertiesConfigParserImpl();
        } else if ("xml".equalsIgnoreCase(extention)) {
            parser = new XmlConfigParserImpl();
        } else if ("ymal".equalsIgnoreCase(extention)) {
            parser = new JsonConfigParserImpl();
            // 未来可能还会有更多的解析需求, 于是就在这里继续添加解析器创建代码... --
        } else {
            //使用运行时异常模拟一下自定义异常: 代表不支持的格式...
            throw new RuntimeException("File format not supported" + ruleConfigFilePath);
        }
        return parser.parse(new File(ruleConfigFilePath));
    }

    // 模拟获取解析文件的扩展名
    public String getFileExtention(String ruleConfigFilePath) {
        return "JSON";
    }
}
