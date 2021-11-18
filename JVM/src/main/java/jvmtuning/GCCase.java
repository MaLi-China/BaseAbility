package jvmtuning;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明: 用于不断填充内存
 * 开发人员：@author MaLi
 */
public class GCCase {
    public static void main(String[] args) {
        List<byte[]> list = new LinkedList<>();
        int _1M = 1024 * 1024;  //1M内存空间
        //不断放入1M的填充
        while (true) {
            byte[] filler = new byte[_1M]; //填充物
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(filler);
        }
    }
}
