package interfaces;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class MT02_TestUpper {
    public static void main(String[] args) {
        new MT01_TestInterface() {

            @Override
            public void method3() {

            }
        };

        MT01_TestInterface instance = () -> {
            System.out.println("lambda ...");
        };
    }
}
