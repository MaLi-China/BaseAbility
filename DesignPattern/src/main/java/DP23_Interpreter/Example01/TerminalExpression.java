package DP23_Interpreter.Example01;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}
