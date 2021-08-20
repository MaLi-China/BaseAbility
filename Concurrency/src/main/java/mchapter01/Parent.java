package mchapter01;

/**
 * 功能说明：测试继承中的可重入锁
 * 开发人员：@Author MaLi
 */
public class Parent {
    public synchronized void method() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        Son s = new Son();
        s.method();
    }
}

class Son extends Parent {
    @Override
    public synchronized void method() {
        System.out.println("In Son,this:\n" + this);
        System.out.println("In Son,parent:");
        super.method();
    }
}
