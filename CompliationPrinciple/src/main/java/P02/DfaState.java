package P02;

/**
 * 功能说明：有限状态机的状态枚举
 * 开发人员：@author MaLi
 */
public enum DfaState {
    Initial,

    If, Id_if1, Id_if2, Else, Id_else1, Id_else2, Id_else3, Id_else4, Int, Id_int1, Id_int2, Id_int3, Id, GT, GE,

    Assignment,

    Plus, Minus, Star, Slash,

    SemiColon,
    LeftParen,
    RightParen,

    IntLiteral//
}
