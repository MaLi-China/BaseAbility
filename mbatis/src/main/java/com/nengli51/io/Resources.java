package com.nengli51.io;

import java.io.InputStream;

/**
 * 功能说明：工具类
 * 开发人员：@author MaLi
 */
public class Resources {
    public static InputStream getResourceAsStream(String filePath) {
        InputStream inputStream = Resources.class.getClassLoader().getResourceAsStream(filePath);
        return inputStream;
    }
}
