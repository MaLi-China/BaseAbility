package mchapter03_stack;

import org.junit.Test;

/**
 * 功能说明：括号合法检测
 * 1, 使用栈结构压栈左括号;
 * 2, 遇到右括号, 弹栈, 与该栈顶元素匹配, 如果配对则继续
 * 3, 如果遇到不匹配的括号对, 则匹配失败
 * <p>
 * 使用ArrayStackPlus实现该程序
 * 开发人员：@author MaLi
 */
public class BracketsMatching {
    /**
     * 检测入口
     *
     * @param brackets 含有括号的字符串
     * @return true即括号匹配合法
     */
    public boolean match(String brackets) {
        int length = brackets.length();
        ArrayStack stack = new ArrayStack(length);
        boolean result = false;
        for (int i = 0; i < length; i++) {
            result = controller(stack, brackets.charAt(i));
            if (!result) {
                System.out.println("不匹配的括号");
                return false;
            }
        }
        System.out.println("合法的括号");
        return true;
    }

    /**
     * 决定入栈or匹配
     * 是左括号 - 入栈
     * 是右括号 - 与栈顶元素匹配
     *
     * @param stack   栈结构
     * @param bracket 字符串的字符
     * @return 左右两边匹配成功返回true
     */
    public boolean controller(ArrayStack stack, char bracket) {
        boolean flag = false;
        switch (bracket) {
            //1, 遇到左, 入栈
            case '{':
            case '[':
            case '(':
                stack.push(bracket);
                flag = true;
                break;
            //2, 遇到右, 弹栈并比较
            case '}':
            case ']':
            case ')':
                Character left = (Character) stack.pop();
                flag = check(left, bracket);
                break;
            default:
                flag = true;
                break;
        }
        return flag;
    }

    /**
     * 左右两边括号匹配比较
     *
     * @param left  左括号
     * @param right 右括号
     * @return 匹配返回true
     */
    public boolean check(char left, char right) {
        boolean result = false;
        if ((left == '{' && right == '}') || (left == '[' && right == ']') || (left == '(' && right == ')')) {
            result = true;
        }
        return result;
    }


    @Test
    public void testMatch() {
        String brackets = "{[(())]}";
        match(brackets);
    }
}
