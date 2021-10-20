package P02;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：用于解析比较表达式的词法解析器
 * 开发人员：@author MaLi
 */
public class SimpleLexer {
    private Token currentToken; // 用于保存当前token
    private StringBuffer tokenText; //用于临时存储token的字符
    private List<Token> tokens; //用于保存解析后的结果token

    public void printTokes() {
        for (Token token : tokens) {
            System.out.println(token);
        }
    }

    public static void main(String[] args) {
        String script = "int age = 45;";
        SimpleLexer lexer = new SimpleLexer();
        lexer.tokenize(script);
        lexer.printTokes();
    }

    // 有限状态机状态判断
    private DfaState changeState(char ch) {
        // Condition2: 旧状态结束时候-初始化
        if (tokenText.length() > 0) {
            //临时数据封装到Token对象中
            currentToken.setText(tokenText.toString());
            //token放到解析结果中
            tokens.add(currentToken);
            //初始化容器与token
            tokenText = new StringBuffer();
            currentToken = new Token();
        }

        // Condition1: 首字母启动新状态时候状态判断
        DfaState newState;
        if (isAlpha(ch)) {
            // 首字符是字母
            if (ch == 'i') {    //判断是否是int的开头
                newState = DfaState.Id_int1;
            } else {            //判断是否是标识符
                newState = DfaState.Id;
            }
            currentToken.setType(TokenType.Identifier); //给Token设置状态
            tokenText.append(ch);   //给临时字符串添加该字符
        } else if (isDigit(ch)) {
            // 首字符是数字
            newState = DfaState.IntLiteral;
            currentToken.setType(TokenType.IntLiteral);
            tokenText.append(ch);
        } else if (ch == '=') {
            // 首字符是 "="
            newState = DfaState.Assignment;
            currentToken.setType(TokenType.Assignment);
            tokenText.append(ch);
        } else if (ch == ';') {
            newState = DfaState.SemiColon;
            currentToken.setType(TokenType.SemiColon);
            tokenText.append(ch);
        } else {
            newState = DfaState.Initial;
        }
        return newState;
    }

    private boolean isAlpha(char ch) {
        return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }


    // 词法解析
    public void tokenize(String code) {
        // Step1: 初始化
        tokens = new ArrayList<>();
        tokenText = new StringBuffer();
        currentToken = new Token();
        DfaState dfaState = DfaState.Initial;

        // Step2: 启动状态机
        CharArrayReader charArrayReader = new CharArrayReader(code.toCharArray());
        int index;
        char ch = 0; //读取到的字符
        try {
            while ((index = charArrayReader.read()) != -1) {
                //读取字符, 并根据读取的字符改变有限状态机的状态
                ch = (char) index;
                switch (dfaState) {
                    case Initial:       //初始状态
                    case Assignment:    //赋值状态

                    case GE:            // >=状态
                        dfaState = changeState(ch);      //重新确定新token状态
                        break;
                    case Id: //标识符状态
                        if (isAlpha(ch) || isDigit(ch)) {
                            tokenText.append(ch);       // 后续的字母直接添加
                        } else {
                            dfaState = changeState(ch);  // 退出标识符状态
                        }
                        break;
                    case GT:
                        if (ch == '=') {
                            dfaState = DfaState.GE;
                            tokenText.append(ch);
                            currentToken.setType(TokenType.GE);
                        } else {
                            dfaState = changeState(ch);  // 退出GT状态
                        }
                        break;
                    case IntLiteral:
                        if (isDigit(ch)) {
                            tokenText.append(ch);
                        } else {
                            dfaState = changeState(ch);  // 退出整形字面量状态
                        }
                        break;
                    case Id_int1:
                        if (ch == 'n') {
                            dfaState = DfaState.Id_int2;
                            tokenText.append(ch);
                        } else if (isAlpha(ch) || isDigit(ch)) {
                            dfaState = DfaState.Id;   //切换状态机状态
                            tokenText.append(ch);
                        } else {
                            dfaState = changeState(ch);  // 退出状态
                        }
                        break;
                    case Id_int2:
                        if (ch == 't') {
                            dfaState = DfaState.Id_int3;
                            tokenText.append(ch);
                        } else if (isAlpha(ch) || isDigit(ch)) {
                            dfaState = DfaState.Id;   //切换状态机状态
                            tokenText.append(ch);
                        } else {
                            dfaState = changeState(ch);  // 退出状态
                        }
                        break;
                    case Id_int3:
                        if (isAlpha(ch) || isDigit(ch)) {
                            dfaState = DfaState.Id;   //切换状态机状态
                            tokenText.append(ch);
                        } else if (isBlank(ch)) {
                            currentToken.setType(TokenType.Int);
                            dfaState = changeState(ch);
                        }
                        break;
                    case SemiColon:     //分号结尾,改语句结束
                        break;
                    default:
                        break;
                }
            }
            // 把最后一个token送进去
            if (tokenText.length() > 0) {
                changeState(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isBlank(char ch) {
        return ch == ' ' || ch == '\t' || ch == '\n';
    }
}
