package CreationalPattern.Factory.SimpleFactory.example;

import CreationalPattern.Factory.SimpleFactory.example.parsers.IRuleConfigParser;
import CreationalPattern.Factory.SimpleFactory.example.parsers.impl.JsonRuleConfigParserImpl;
import CreationalPattern.Factory.SimpleFactory.example.parsers.impl.PropertiesRuleConfigParserImpl;
import CreationalPattern.Factory.SimpleFactory.example.parsers.impl.XmlRuleConfigParserImpl;
import CreationalPattern.Factory.SimpleFactory.example.parsers.impl.YmalRuleConfigParserImpl;

/**
 * 功能: 工厂类
 * 简单工厂设计模式
 */
public class RuleConfigSourceParserFactory {

    /**
     * 创建parser
     *
     * @param fileExtension 文件扩展名
     * @return 返回parser
     */
    public static IRuleConfigParser createParser(String fileExtension) {
        IRuleConfigParser parser;
        //根据配置文件路径名, 创建合适的parser
        if (fileExtension.equalsIgnoreCase("json")) {
            parser = new JsonRuleConfigParserImpl();
        } else if (fileExtension.equalsIgnoreCase("xml")) {
            parser = new XmlRuleConfigParserImpl();
        } else if (fileExtension.equalsIgnoreCase("yaml")) {
            parser = new YmalRuleConfigParserImpl();
        } else if (fileExtension.equalsIgnoreCase("properties")) {
            parser = new PropertiesRuleConfigParserImpl();
        } else {
            throw new IllegalArgumentException("当前配置文件没有匹配的解析器,请使用json, xml, yaml, properties配置文件中的一种!");
        }
        return parser;
    }
}