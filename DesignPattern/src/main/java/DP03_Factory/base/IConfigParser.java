package DP03_Factory.base;

import java.io.File;

/**
 * 功能说明：解析器协议
 * 开发人员：@author MaLi
 */
public interface IConfigParser {
    Config parse(File file);
}
