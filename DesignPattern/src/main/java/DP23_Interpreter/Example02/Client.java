package DP23_Interpreter.Example02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 功能说明：可以进行加减运算发表达式解析测试
 * 开发人员：@author MaLi
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // 获取表达式
        String expStr = getExpStr();
        // 获取操作数值
        HashMap<String, Integer> var = getValue(expStr);
        // 解析表达式
        Calculator calculator = new Calculator(expStr);
        // 计算表达式的值
        System.out.println("运算结果：" + expStr + "=" + calculator.run(var));
    }

    //获得表达式
    public static String getExpStr() throws IOException {
        System.out.print("请输入表达式：");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    //获得值映射
    public static HashMap<String, Integer> getValue(String expStr) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        for (char ch : expStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                if (!map.containsKey(String.valueOf(ch))) {
                    System.out.print("请输入" + ch + "的值：");
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }
        return map;
    }
}
