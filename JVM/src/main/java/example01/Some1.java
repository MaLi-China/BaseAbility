package example01;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/7
 */
public class Some1 {
    private Some2 some2;

    public void show() {
        some2 = new Some2();
        some2.show();
    }

    public static void main(String[] args) {
        try {
            Some1 some = new Some1();
            some.show();
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
