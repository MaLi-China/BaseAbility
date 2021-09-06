package DP02_Strategy;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class CalculaitonClient {
    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        calculation.addExecutor(() -> System.out.println("SQL1"));

        calculation.addExecutor(() -> System.out.println("SQL2"));

        calculation.calculate();
    }
}
