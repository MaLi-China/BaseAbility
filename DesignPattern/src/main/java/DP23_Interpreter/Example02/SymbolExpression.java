package DP23_Interpreter.Example02;

import java.util.HashMap;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public abstract class SymbolExpression extends Expression {
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 符号表达式的解析方法作用: 计算得到值
     *
     * @param var 传递操作数值字典
     * @return 返回计算结果
     */
    @Override
    public abstract int interpreter(HashMap<String, Integer> var);
}
