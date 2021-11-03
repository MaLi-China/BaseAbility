package exception;

/**
 * 功能说明：异常展示
 * 开发人员：@author MaLi
 */
public class T01_Catch {
    public static void main(String[] args) {
        try {
            int result = 1 / 0;
        } catch (Exception e) {

        }
        System.out.println("running...");
    }
}
