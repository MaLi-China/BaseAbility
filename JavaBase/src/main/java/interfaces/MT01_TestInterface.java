package interfaces;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public interface MT01_TestInterface {
    default void method1() {
        System.out.println("default method1");
    }

    default void method2() {
        System.out.println("default method1");
    }

    void method3();

//    void method4();
}
