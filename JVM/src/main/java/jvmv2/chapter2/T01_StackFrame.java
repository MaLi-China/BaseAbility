package jvmv2.chapter2;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class T01_StackFrame {
    public static void main(String[] args) {
        T01_StackFrame instance = new T01_StackFrame();

        instance.A();
    }

    public void A() {
        int a = 10;
        System.out.println("method A start...");
        System.out.println(a);
        this.B();
        System.out.println("method A end...");
    }

    public void B() {
        int b = 10;
        System.out.println("method B start...");
        System.out.println(b);
        this.C();
        System.out.println("method B end...");
    }

    private void C() {
        int c = 10;
        System.out.println("method C start...");
        System.out.println(c);
        System.out.println("method C end...");
    }
}
