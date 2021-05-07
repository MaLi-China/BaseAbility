package example01;

/**
 * 功能说明：用于演示汇编
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/6
 */
public class Demo1 {
    public int add() {
        int a = 1;
        int b = 2;
        int c = a + b;
        return c;
    }

    public static void main(String[] args) {
        Demo1 demo = new Demo1();
        int result = demo.add();
        System.out.println(result);
    }
}
