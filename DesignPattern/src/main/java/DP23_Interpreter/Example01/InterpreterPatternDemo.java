package DP23_Interpreter.Example01;

/**
 * 功能说明：使用Expression类创建规则
 * 开发人员：@author MaLi
 */
public class InterpreterPatternDemo {
    public static Expression getMaleExpression() {
        TerminalExpression robert = new TerminalExpression("Robert");
        TerminalExpression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    public static Expression getMarriedWomanExpression() {
        TerminalExpression julie = new TerminalExpression("Julie");
        TerminalExpression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarredWoman = getMarriedWomanExpression();
        boolean john = isMale.interpret("John");
        boolean julie_is_married = isMarredWoman.interpret("Julie is Married");
    }

}
