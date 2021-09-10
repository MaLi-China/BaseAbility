package DP01_Singleton.evolution.E2_logger_syn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 功能说明：加锁后的Logger, 加Logger.class级别的锁
 * 问题: 性能, 凡是使用Logger锁的代码都串行化
 * <p>
 * 开发人员：@author MaLi
 */
public class Logger {
    private FileWriter fileWriter;

    public Logger(String path) {
        try {
            fileWriter = new FileWriter(new File(path), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message) {
        synchronized (Logger.class) {
            try {
                fileWriter.write(message);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
