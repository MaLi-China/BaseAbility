package DP23_Interpreter.Example02;

import java.util.HashMap;
import java.util.Stack;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Calculator {
    private Expression expression;

    /**
     * 解析语法树
     *
     * @param expStr 传入表达式
     */
    public Calculator(String expStr) {
        //用于整理语法树
        Stack<Expression> stack = new Stack<>();
        char[] charArray = expStr.toCharArray();

        Expression left;
        Expression right;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    // 变量表达式赋值
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    // 操作符表达式赋值
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':    //减法
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:    //公式中的变量
                    String key = String.valueOf(charArray[i]);
                    VarExpression varExpression = new VarExpression(key);
                    stack.push(varExpression); //第一次放入一个VarExpression变量表达式
                    break;
            }
        }
        this.expression = stack.pop();
    }

    /**
     * 开启计算
     *
     * @param var 操作数与操作数的值
     * @return 返回计算结果
     */
    public int run(HashMap<String, Integer> var) {
        return this.expression.interpreter(var);
    }
}
