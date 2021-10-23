package P03;

/**
 * 功能说明：抽象语法树的结点类型
 * 开发人员：@author MaLi
 */
public enum ASTNodeType {
    Programm,           //程序入口


    IntDeclaration,     //整型变量声明
    ExpressionStmt,     //表达式语句
    AssignmentStmt,     //赋值语句  遇到=

    //语句中的表达式部分
    Primary,        //基础表达式 ?什么是基础表达式
    Mutiplicative,  //乘法表达式
    Additive,       // 加法表达式


    Identifier,     //标识符
    IntLiteral      //整型字面量
}
