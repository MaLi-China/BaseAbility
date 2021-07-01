package jvmv3.chapter02_04_02;

/**
 * 功能说明：测试Java虚拟机栈
 * 1, 栈深度测试
 * 2, 栈内存溢出测试
 * 开发人员：@Author MaLi
 */
public class JavaVMStackSOF {
    private static int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stackLength:" + stackLength);
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
