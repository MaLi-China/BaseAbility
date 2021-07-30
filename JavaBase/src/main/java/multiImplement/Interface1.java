package multiImplement;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public interface Interface1 {
    void add();

    public static void print() {
        System.out.println("Interface1's print...");
    }

    public default void show() {
        System.out.println("Interface1's show...");
    }
}
