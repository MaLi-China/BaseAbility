package CreationalPattern.Factory.SimpleFactory.example.parsers;

import CreationalPattern.Factory.SimpleFactory.example.pojo.RuleConfig;

/**
 * 功能说明：解析器
 * -- 1, 针对不同文件后缀, 可以实现不同文件的解析器
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/2
 */
public interface IRuleConfigParser {
    /**
     * 解析配置文件
     *
     * @param ruleConfigFilePath 配置文件路径
     * @return 返回RuleConfig对象
     */
    RuleConfig parse(String ruleConfigFilePath);
}
