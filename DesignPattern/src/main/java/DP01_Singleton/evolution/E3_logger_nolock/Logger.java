package DP01_Singleton.evolution.E3_logger_nolock;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 功能说明：无锁方式, 使用阻塞队列保证多线程下Logger的线程安全
 * 开发人员：@author MaLi
 */
public class Logger {
    private FileWriter writer;

    public Logger(FileWriter writer) {
        this.writer = writer;
    }

    private BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

    // 多线程写
    public void log(String message) {
        queue.add(message);
    }

    // 单线程获取
    public void write() {
        String message = queue.poll();
        try {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
