package DP07_Observer.Evolution01;

import java.util.concurrent.TimeUnit;


/**
 * 功能说明：使用面向对象的方式, 模拟观察者的需求
 * 开发人员：@author MaLi
 */
public class MainDemo {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = new Parent();
        new Thread(() -> parent.appease(child), "Thread_parent").start();
        new Thread(() -> {
            child.isCry = true;
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Child isCry=" + child.isCry);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread_child").start();

    }

    private static class Child {
        private boolean isCry = false;

        private void cry() {
            this.isCry = true;
            System.out.println("Cry...");
        }
    }

    private static class Parent {
        private void appease(Child child) {
            while (!child.isCry) {
                System.out.println("没有哭...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("孩子哭了, 安抚一下Appease...");
            child.isCry = false;
        }
    }
}



