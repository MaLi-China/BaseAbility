package DP03_Factory.P02_SimpleFactory;

import DP03_Factory.base.Config;
import DP03_Factory.base.IConfigParser;

import java.io.File;

/**
 * 功能说明：模拟在客户端使用简单工厂
 * 作用:
 * 1, 将创建对象的过程在当前使用对象的代码中解耦;
 * 2, 复杂的代码变简介
 * 开发人员：@author MaLi
 */
public class ResourceConfiguration {
    public Config load(String ruleConfigFilePath) {
        //获取工厂
        ConfigParserFactory configParserFactory = new ConfigParserFactory(); //生产使用注入方式 - 此处使用new代替了注入工厂实例
        //获取对象
        IConfigParser configParser = configParserFactory.getConfigParser(ruleConfigFilePath);
        //使用对象
        return configParser.parse(new File(ruleConfigFilePath));
    }
}
