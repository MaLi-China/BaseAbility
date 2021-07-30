package multiImplement;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public interface Interface2 {
    void add();

    public static void print() {
        System.out.println("Interface2's print...");
    }

    public default void show() {
        System.out.println("Interface2's show...");
    }
}
