package com.nengli51.io;

import java.io.InputStream;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Resources {
    /**
     * 获取指定文件的字节输入流
     *
     * @param path 文件path
     * @return 字节输入流
     */
    public static InputStream getResourceAsStream(String path) {
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}
