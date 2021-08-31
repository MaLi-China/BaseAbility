package mchapter05;

/**
 * 功能说明：测试使用ThreadLocal
 * 线程独有的容器, 作用: 因为变量被共享访问, 才会出现线程安全问题, 那么给每个线程一个独有的资源, 用于解决线程安全问题
 * 开发人员：@Author MaLi
 */
public class T01_ThreadLocal {

    public static void main(String[] args) {
        SomeObject some = new SomeObject();
        //线程1 保存变量到ThreadLocal中
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            some.save(threadName + " save msg: " + "hello");
            String msg = some.get();
            System.out.println(threadName + " get msg: " + msg);
        }).start();

        //线程2 尝试获取ThreadLocal中的变量
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            String msg = some.get();
            System.out.println(" --> " + threadName + " get msg: " + msg);
        }).start();
    }

    static class SomeObject {
        private ThreadLocal<String> threadLocal = new ThreadLocal<>();

        public void save(String msg) {
            threadLocal.set(msg);
            threadLocal.set("xxxxx");
        }

        public String get() {
            return threadLocal.get();
        }
    }
}
