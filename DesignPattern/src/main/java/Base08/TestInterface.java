package Base08;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public interface TestInterface {
    String msg = "Hello Interface";

    default void doSomething() {
        System.out.println(msg);
    }
}
