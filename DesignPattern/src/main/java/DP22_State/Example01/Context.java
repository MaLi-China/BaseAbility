package DP22_State.Example01;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Context {
    private State state;

    public Context() {
        this.state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
