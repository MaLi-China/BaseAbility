package com.nengli51.io;

import java.io.InputStream;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class Resources {
    public static InputStream loadConfig(String path) {
        InputStream inputStream = Resources.class.getClassLoader().getResourceAsStream(path);
        return inputStream;
    }
}
