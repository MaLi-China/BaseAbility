package CreationalPattern.Factory.SimpleFactory.example;

import CreationalPattern.Factory.SimpleFactory.example.parsers.IRuleConfigParser;
import CreationalPattern.Factory.SimpleFactory.example.parsers.impl.JsonRuleConfigParserImpl;
import CreationalPattern.Factory.SimpleFactory.example.parsers.impl.PropertiesRuleConfigParserImpl;
import CreationalPattern.Factory.SimpleFactory.example.parsers.impl.XmlRuleConfigParserImpl;
import CreationalPattern.Factory.SimpleFactory.example.parsers.impl.YmalRuleConfigParserImpl;
import CreationalPattern.Factory.SimpleFactory.example.pojo.RuleConfig;

/**
 * 功能说明：配置类
 * 功能: 将存储在文件中的配置解析成内存对象RuleConfige
 * 配置文件的类型: json、xml、yaml、properties
 * 需要根据不同的文件类型, 选择不同的解析方式
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/2
 */
public class RuleConfigSource {
    /**
     * 功能: 加载配置文件
     *
     * @param ruleConfigFilePath 配置文件全路径名
     * @return 返回配置对象
     */
    public RuleConfig load(String ruleConfigFilePath) {
        String fileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = createParser(fileExtension);
        return parser.parse(ruleConfigFilePath);
    }

    /**
     * 创建parser
     *
     * @param fileExtension 文件扩展名
     * @return 返回parser
     */
    private IRuleConfigParser createParser(String fileExtension) {
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

    /**
     * 功能: 解析文件后缀
     *
     * @param filePath 文件路径
     * @return 返回文件后缀
     */
    public String getFileExtension(String filePath) {

        return "json";
    }
}
