package Base_08;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class MainTest {
    public static void main(String[] args) {
        TestInterface.executeStaticMethod();
        TestInterface anInterface = new TestInterface() {
        };
        anInterface.doSomething();
    }
}
