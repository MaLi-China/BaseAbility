package DP23_Interpreter.Example02;

import java.util.HashMap;

/**
 * 功能说明：Addition Interpreter
 * 开发人员：@author MaLi
 */
public class AddExpression extends SymbolExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
