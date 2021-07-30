package jvmv3.chapter04_02;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class Test_jstack {

    public static void main(String[] args) {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running...");
        }
    }
}
