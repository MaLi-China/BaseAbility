package DP22_State.Example06;

/**
 * 功能说明：拥有状态属性的类, 会根据状态的改变, 发生属性行为等改变
 * 开发人员：@author MaLi
 */
public class Child {
    private String expression;//代表表情
    private String mood; //代表心情
    private boolean isFull;//代表饱饿
    private boolean isSleepEnough;//代表是否睡醒
    private ChildState childState;
    private IState state;

    public Child(IState state) {
        this.state = state;
    }

    public void eat() {
        state.eat();
    }

    public void sleep() {
        state.sleep();
    }

    public void play() {
        state.play();
    }

    public void scare() {
        state.scare();
    }

}
