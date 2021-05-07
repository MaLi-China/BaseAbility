package example02;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 功能说明：测试内存溢出
 * <p>
 * VM options: -Xms16m -Xmx16m
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/7
 */
public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            String str = "";
            for (int j = 0; j < 1000; j++) {
                // 测试代码: 让堆内存溢出用
                str += UUID.randomUUID().toString();
            }
            list.add(str);
        }
        System.out.println("OK");
    }
}
