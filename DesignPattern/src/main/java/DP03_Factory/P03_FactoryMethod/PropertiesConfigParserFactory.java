package DP03_Factory.P03_FactoryMethod;

import DP03_Factory.base.IConfigParser;
import DP03_Factory.base.PropertiesConfigParserImpl;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class PropertiesConfigParserFactory implements ParserFactory {
    @Override
    public IConfigParser getConfigParser(String ruleConfigFilePath) {
        return new PropertiesConfigParserImpl();
    }
}
