package CreationalPattern.Factory.SimpleFactory.example;

import CreationalPattern.Factory.SimpleFactory.example.parsers.IRuleConfigParser;
import CreationalPattern.Factory.SimpleFactory.example.parsers.impl.JsonRuleConfigParserImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能说明: 带缓存功能的工厂
 */
public class RuleConfigSourceParserFactory_cache {
    public static Map<String, IRuleConfigParser> parsesMap = new HashMap<>();

    static {
        parsesMap.put("json", new JsonRuleConfigParserImpl());
        parsesMap.put("xml", new JsonRuleConfigParserImpl());
        parsesMap.put("yaml", new JsonRuleConfigParserImpl());
        parsesMap.put("properties", new JsonRuleConfigParserImpl());
    }


    /**
     * 创建parser
     *
     * @param fileExtension 文件扩展名
     * @return 返回parser
     */
    public static IRuleConfigParser createParser(String fileExtension) {
        //根据配置文件路径名, 创建合适的parser
        if (fileExtension == null || fileExtension.isEmpty()) {
            throw new IllegalArgumentException("当前配置文件没有匹配的解析器,请使用json, xml, yaml, properties配置文件中的一种!");
        }
        return parsesMap.get(fileExtension);
    }
}