package jvmtuning;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class DeapLoopCase {
    public static void main(String[] args) {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
