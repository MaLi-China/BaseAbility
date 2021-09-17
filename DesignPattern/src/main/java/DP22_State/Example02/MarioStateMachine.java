package DP22_State.Example02;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class MarioStateMachine {
    private int score;
    private State currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    /**
     * 吃蘑菇
     */
    public void obtainMushRoom() {
        if (currentState.equals(State.SMALL)) {
            this.score += 100;
            currentState = State.SUPER;
        }
    }

    /**
     * 获取斗篷
     */
    public void obtainCape() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            this.score += 200;
            currentState = State.CAPE;
        }
    }

    /**
     * 获取火花武器
     */
    public void obtainFireFlower() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            this.score += 300;
            currentState = State.FIRE;
        }
    }

    /**
     * 遇到妖怪
     */
    public void meetMonster() {
        if (currentState.equals(State.SUPER)) {
            this.score -= 100;
            currentState = State.SMALL;
        } else if (currentState.equals(State.CAPE)) {
            this.score -= 200;
            currentState = State.SMALL;
        } else if (currentState.equals(State.FIRE)) {
            this.score -= 300;
            currentState = State.SMALL;
        }
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return currentState;
    }
}
