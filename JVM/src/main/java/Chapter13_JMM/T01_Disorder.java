package Chapter13_JMM;

import org.junit.Test;

/**
 * 功能说明： 测试CPU的乱序执行
 * -Xcomp:编译执行模式下, 一样会出现乱序现象, 这是CPU的优化执行策略
 * 开发人员：@author MaLi
 */
public class T01_Disorder {
    int x = 0, y = 0;
    int a = 0, b = 0;

    @Test
    public void doAction() {

        int i = 0;
        while (true) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            i++;
            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String result = "第 " + i + " 次(" + x + "," + y + ")";
            if (x == 0 && y == 0) {
                System.out.println(result);
                break;
            }
        }
    }
}
