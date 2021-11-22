package method_reference;

/**
 * 功能说明：方法引用, 替代lambda表达式
 * 开发人员：@author MaLi
 */
public class T01_Usage {
    public static void method(SomeObject object) {
        object.m1();
    }

    public interface SomeObject {
        void m1();
    }

    public static void main(String[] args) {
        SomeObject object = new SomeObject() {
            @Override
            public void m1() {
                System.out.println("匿名内部类");
            }
        };
        method(() -> {
            System.out.println("lambda m1");
        });
    }
}
