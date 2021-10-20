package P02;

/**
 * 功能说明：有限状态机的状态
 * 开发人员：@author MaLi
 */
public enum TokenType {
    Plus,           // +
    Minus,          // -
    Star,           // *
    Slash,          // /

    GE,             // >=
    GT,             // >
    EQ,             // ==
    LE,             // <=
    LT,             // <

    SemiColon,      // ;
    LeftParen,      // (
    RightParen,     // )

    Assignment,     // = 赋值运算符

    If,             // 分支if
    Else,           // 分支else

    Int,            //整形
    Identifier,     //标识符
    IntLiteral,     //整型字面量
    StringLiteral   //字符串字面量
}
