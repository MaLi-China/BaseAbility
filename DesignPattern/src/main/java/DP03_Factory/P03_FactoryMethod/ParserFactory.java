package DP03_Factory.P03_FactoryMethod;

import DP03_Factory.base.IConfigParser;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public interface ParserFactory {
    IConfigParser getConfigParser(String ruleConfigFilePath);
}
