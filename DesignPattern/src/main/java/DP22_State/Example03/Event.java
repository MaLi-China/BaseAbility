package DP22_State.Example03;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public enum Event {
    //使用构造函数, 引入一个value参数的目的, 作为二维数组索引
    GOT_MUSHROOM(0),
    GOT_CAPE(1),
    GOT_FIRE(2),
    MET_MONSTER(3);
    private int value;

    Event(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
