package DP23_Interpreter.Example02;

import java.util.HashMap;

/**
 * 功能说明：变量解析器
 * 开发人员：@author MaLi
 */
public class VarExpression extends Expression {
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    /**
     * 变量表达式的作用: 获取变量的值
     *
     * @param var 传递操作数的值map
     * @return 返回结果
     */
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
