package DP22_State.Example03;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public enum State {
    //使用构造函数, 引入一个value参数的目的, 作为二维数组索引
    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);

    private int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
