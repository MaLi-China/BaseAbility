package jvmv3.chapter03_02_01;

/**
 * 功能说明：测试循环引用的GC
 * 开发人员：@Author MaLi
 * <p>
 * VM args: -XX:+PrintGC
 */
public class ReferenceCountingGC {
    public Object instance = null;
    final int _1M = 1024 * 1024;
    private byte[] bigsize = new byte[2 * _1M];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        try {
            objA.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        objA = null;
        objB = null;
//        System.gc();
    }
}
