package jvmv3.chapter03_08_01;

/**
 * 功能说明：测试MinorGC时候的内存分配
 * 开发人员：@Author MaLi
 */
public class Test1_MinorGC {
    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1M];
        allocation2 = new byte[2 * _1M];
        allocation3 = new byte[2 * _1M];
        allocation4 = new byte[4 * _1M];
    }
}
