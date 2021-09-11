package DP01_Singleton.evolution.E4_logger_Singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 功能说明：使用单例, 保证全局一个对象
 * 开发人员：@author MaLi
 */
public class Logger {
    private Logger logger;
    private FileWriter fileWriter;

    private Logger() {
        logger = new Logger();
    }

    public Logger getInstance(String path) {
        try {
            fileWriter = new FileWriter(new File(path), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logger;
    }
}
