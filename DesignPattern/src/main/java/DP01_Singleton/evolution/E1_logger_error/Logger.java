package DP01_Singleton.evolution.E1_logger_error;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 功能说明：错误示例, 在不使用单例的情况下, 如下代码的问题
 * 假如, 多线程写入同一个path路径下的文件, 这时候可能会线程之间覆盖其它线程的输出.
 * <p>
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
