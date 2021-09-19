package DP22_State.Example06;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class HappyState implements IState {

    private Child child;


    @Override
    public void eat() {
    }

    @Override
    public void sleep() {

    }

    @Override
    public void play() {

    }

    @Override
    public void scare() {

    }

    public void setChild(Child child) {
        this.child = child;
    }
}
