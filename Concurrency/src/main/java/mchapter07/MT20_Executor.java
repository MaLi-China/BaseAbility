package mchapter07;

import java.util.concurrent.Executor;

/**
 * 功能说明：初识Executor
 * 运行结果如下;
 * <p>
 * hello executor1
 * MyExecutor1 当前线程名称: main
 * hello executor2
 * MyExecutor2 当前线程名称: Thread_new
 * <p>
 * <p>
 * 思考问题: 为什么大师要在已经有了创建和运行线程的方式下,重复早轮子, 提供一个Executor呢?
 * 回答: 之前的创建线程的方式
 * 1, 继承Thread
 * 2, 实现Runnable接口
 * 这两种方式,定义任务和运行是集中在一起的, Executor只负责运行.
 * 开发人员：@author MaLi
 */
public class MT20_Executor {
    public static void main(String[] args) {
        //方式1, 直接运行, 也就是在caller线程中提交到Executor
        new MyExecutor1().execute(() -> System.out.println("hello executor1"));
        // 方式2, 异步运行
        new MyExecutor2().execute(() -> System.out.println("hello executor2"));
    }

    static class MyExecutor1 implements Executor {

        @Override
        public void execute(Runnable command) {
            //直接运行的方式
            command.run();
            System.out.println("MyExecutor1 当前线程名称: " + Thread.currentThread().getName());
        }
    }

    static class MyExecutor2 implements Executor {

        @Override
        public void execute(Runnable command) {
            //异步的方式运行提交的新线程
            new Thread(() -> {
                command.run();
                System.out.println("MyExecutor2 当前线程名称: " + Thread.currentThread().getName());
            }, "Thread_new").start();
        }
    }
}
