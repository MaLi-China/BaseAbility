package Base_08;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public interface TestInterface {
    String msg = "Hello Interface";

    static void executeStaticMethod() {
        System.out.println("Static methods");
    }

    default void doSomething() {
        System.out.println(msg);
    }
}
