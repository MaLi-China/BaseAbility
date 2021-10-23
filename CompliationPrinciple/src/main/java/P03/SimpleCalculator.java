package P03;

import P02.SimpleLexer;
import P02.Token;
import P02.TokenType;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();

        //测试变量声明语句的解析
        String script = "int a = b+3;";
        System.out.println("解析变量声明语句: " + script);
        SimpleLexer lexer = new SimpleLexer();
        TokenReader tokens = lexer.tokenize(script);
        try {
            SimpleASTNode node = calculator.intDeclare(tokens);
            calculator.dumpAST(node, "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void dumpAST(ASTNode node, String indent) {
        System.out.println(indent + node.getType() + " " + node.getText());
        for (ASTNode child : node.getChildren()) {
            dumpAST(child, indent + "\t");
        }
    }
    //Step1: 解析声明语句部分

    /**
     * 整型声明表达式解析
     *
     * @param tokenReader
     * @return
     * @throws Exception
     */
    public SimpleASTNode intDeclare(TokenReader tokenReader) throws Exception {
        SimpleASTNode astNode = null;
        //1, 预读int
        Token token = tokenReader.peek();
        if (token != null && token.getType() == TokenType.Int) {
            token = tokenReader.read();
            //2, 预读Identifier
            token = tokenReader.peek();
            //能读到标识符, 说明这是一个Int变量声明语句
            if (token.getType() == TokenType.Identifier) {
                token = tokenReader.read();// 消耗掉标识符
                astNode = new SimpleASTNode(ASTNodeType.IntDeclaration, token.getText()); //tokenText是变量名称
                //3, 预读= 调表达式匹配 如果能匹配上, 就去匹配加法表达式
                token = tokenReader.peek();
                if (token != null && token.getType() == TokenType.Assignment) {
                    //如果能读到=, 代表后面跟的是初始化表达式
                    token = tokenReader.read();
                    //4, 解析加法表达式
                    SimpleASTNode child = this.additive(tokenReader);
                    //检查
                    if (child == null) {
                        throw new Exception("invalide variable initialization, expecting an expression");
                    } else {
                        astNode.addChilden(child);
                    }
                }
                //5, 解析分号结尾
                token = tokenReader.peek();
                if (token != null && token.getType() == TokenType.SemiColon) {
                    tokenReader.read();
                } else {
                    throw new Exception("invalid statement, expecting semicolon");
                }
            } else {
                //如果int 之后没有标识符
                throw new Exception("variable name expected");
            }
        }
        return astNode;
    }

    //Step2: 解析表达式部分

    /**
     * 加法表达式解析
     *
     * @param tokenReader
     * @return
     */
    private SimpleASTNode additive(TokenReader tokenReader) throws Exception {
        //1, 解析整个式子是否是乘法(设定的乘法优先级>加法优先级)
        //1, 基本表达式解析: 返回标识符
        SimpleASTNode childLeft = this.multipleicative(tokenReader);
        SimpleASTNode node = childLeft;
        //预读标识符: 运算符
        Token token = tokenReader.peek();
        if (childLeft != null && token != null) {
            if (token.getType() == TokenType.Plus || token.getType() == TokenType.Minus) {
                token = tokenReader.read();
                SimpleASTNode childRight = multipleicative(tokenReader);
                if (childRight != null) {
                    // 代表运算符的结点
                    node = new SimpleASTNode(ASTNodeType.Additive, token.getText());
                    node.addChilden(childLeft);
                    node.addChilden(childRight);
                } else {
                    throw new Exception("invalid additive expression, expecting the right part.");
                }
            }
        }
        return node;
    }

    /**
     * 乘法表达式解析
     *
     * @param tokenReader
     * @return
     */
    private SimpleASTNode multipleicative(TokenReader tokenReader) throws Exception {
        //1, 基本表达式解析: 返回标识符
        SimpleASTNode childLeft = this.primary(tokenReader);
        SimpleASTNode node = childLeft;
        //预读标识符: 运算符
        Token token = tokenReader.peek();
        if (childLeft != null && token != null) {
            if (token.getType() == TokenType.Star || token.getType() == TokenType.Slash) {
                token = tokenReader.read();
                SimpleASTNode childRight = multipleicative(tokenReader);
                if (childRight != null) {
                    // 代表运算符的结点
                    node = new SimpleASTNode(ASTNodeType.Mutiplicative, token.getText());
                    node.addChilden(childLeft);
                    node.addChilden(childRight);
                } else {
                    throw new Exception("invalid multiplicative expression, expecting the right part.");
                }
            }
        }
        return node;
    }

    //基本表达式解析
    private SimpleASTNode primary(TokenReader tokenReader) throws Exception {
        SimpleASTNode node = null;
        Token token = tokenReader.peek();
        if (token != null) {
            token = tokenReader.read();
            if (token.getType() == TokenType.IntLiteral) {
                //类型是int关键字
                node = new SimpleASTNode(ASTNodeType.IntLiteral, token.getText());
            } else if (token.getType() == TokenType.Identifier) {
                //类型是标识符
                node = new SimpleASTNode(ASTNodeType.Identifier, token.getText());
            } else if (token.getType() == TokenType.LeftParen) {
                //类型是左括号
                node = this.additive(tokenReader); //继续调加法表达式做计算, 直到遇到右括号, 返回一个node
                if (node != null) {
                    token = tokenReader.peek();
                    if (token != null && token.getType() == TokenType.RightParen) {
                        tokenReader.read();//消耗掉,
                    } else {
                        //否则抛出语法错误
                        throw new Exception("expecting right parenthesis");
                    }
                } else {
                    //括号中没有内容
                    throw new Exception("expecting an additive expression inside parenthesis");
                }
            }
        }
        return node;
    }
}
