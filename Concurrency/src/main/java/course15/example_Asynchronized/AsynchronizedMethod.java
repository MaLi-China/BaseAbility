package course15.example_Asynchronized;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：异步编程 - 异步方法(在方法内部创建一个新线程, 执行方法逻辑)
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/10
 */
public class AsynchronizedMethod {
    public static List<Integer> calcPi() {
        List<Integer> result = new ArrayList<>(3);

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("计算中...");
                result.add(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("计算结束!");
        }).start();
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = calcPi();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main Thread...获取到结果: " + result.get(0));
    }
}
