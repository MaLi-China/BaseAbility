package DP22_State.Example02;

/**
 * 功能说明：状态模式作用 - 状态改变, 属性发生变化
 * 开发人员：@author MaLi
 */
public class ApplicationDemo {
    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        //Event发生
        mario.obtainMushRoom();
        //状态改变
        int score = mario.getScore();
        State currentState = mario.getCurrentState();
        System.out.println("mario score: " + score + "; state: " + currentState);
    }
}
