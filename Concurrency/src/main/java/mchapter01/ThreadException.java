package mchapter01;

/**
 * 功能说明：线程中产生异常, 其它线程会产生什么结果
 * 开发人员：@Author MaLi
 */
public class ThreadException {
    private static int count = 0;

    public static void method() {
        while (true) {
            count++;
            if (count == 5) {
                int result = 1 / 0;
            }
            System.out.println("MethodThread: " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(ThreadException::method).start();
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("MainThread: " + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
