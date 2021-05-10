package course15.example_Asynchronized;

/**
 * 功能说明：异步实现的方式1: 异步调用(创建一个线程去执行方法)
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/10
 */
public class AsynchronizedInvocation {
    public static int calcPi() {
        try {
            Thread.sleep(2000);
            System.out.println("计算中...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("计算结束!");
        return 10000;
    }

    public static void main(String[] args) {
        new Thread(AsynchronizedInvocation::calcPi).start();
        System.out.println("main Thread...");
    }
}

