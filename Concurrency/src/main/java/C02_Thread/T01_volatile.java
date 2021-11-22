package C02_Thread;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：示例volatile
 * 开发人员：@author MaLi
 */
public class T01_volatile {
    public static /*volatile*/ boolean flag = true;

    public void doAction() {
        System.out.println("start");
        while (flag) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("doAction...");
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        new Thread(() -> {
            T01_volatile obj = new T01_volatile();
            obj.doAction();
        }).start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Set flag to false");
        flag = false;

    }
}
