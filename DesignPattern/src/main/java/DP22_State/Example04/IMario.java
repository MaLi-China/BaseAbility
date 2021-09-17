package DP22_State.Example04;

/**
 * 功能说明：Mario所有的状态要实现的接口
 * 开发人员：@author MaLi
 */
public interface IMario {
    State getName();

    //以下是所有的事件
    void obtainMushRoom();

    void obtainCap();

    void obtainFireFlower();

    void meetMonster();
}
