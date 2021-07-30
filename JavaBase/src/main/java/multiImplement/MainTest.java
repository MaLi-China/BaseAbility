package multiImplement;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class MainTest implements Interface1, Interface2 {
    @Override
    public void add() {
    }

    @Override
    public void show() {
        Interface1.super.show();
        Interface2.super.show();
    }

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        mainTest.show();
    }
}
