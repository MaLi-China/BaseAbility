package Chapter12_ClassLoader;

/**
 * 功能说明：验证变量的存储位置
 * -Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
 * <p>
 * -XX:-UseCompressedOops: 禁用压缩指针
 * 开发人员：@author MaLi
 */
public class T06_LocationOfVar {
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }

    private static class ObjectHolder {
    }

    public static void main(String[] args) {
        Test test = new T06_LocationOfVar.Test();
        test.foo();
    }
}
