package DP22_State.Example01;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start State";
    }
}
