package LeetCode;

/**
 * 功能说明：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 开发人员：@author MaLi
 */
public class Solution_20 {
    public static void main(String[] args) {
//        String s = "()[]{}";
//        String s = "(]";
//        String s = "([)]";
//        String s = "{[]}";
        String s = "{[]}";
        Solution_20 solution = new Solution_20();
        boolean valid = solution.isValid(s);
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        int length = s.length();
        Stack stack = new Stack(length);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    try {
                        if ('(' == stack.pop())
                            break;
                        else
                            return false;
                    } catch (Exception e) {
                        return false;
                    }
                case ']':
                    try {
                        if ('[' == stack.pop())
                            break;
                        else
                            return false;
                    } catch (Exception e) {
                        return false;
                    }
                case '}':
                    try {
                        if ('{' == stack.pop())
                            break;
                        else
                            return false;
                    } catch (Exception e) {
                        return false;
                    }
                default:
                    return false;
            }

        }
        if (stack.getCurrentIndex() > 0) {
            return false;
        }
        return true;
    }

    public static class Stack {
        private char[] container;
        private int length;
        private int currentIndex;

        public int getCurrentIndex() {
            return currentIndex;
        }

        public Stack(int length) {
            this.length = length;
            this.container = new char[this.length];
            this.currentIndex = -1;
        }

        public void push(char c) {
            container[++currentIndex] = c;
        }

        public char pop() {
            if (currentIndex < 0) {
                throw new RuntimeException();
            }
            return container[currentIndex--];
        }
    }
}
