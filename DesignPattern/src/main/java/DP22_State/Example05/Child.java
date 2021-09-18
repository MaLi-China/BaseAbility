package DP22_State.Example05;

/**
 * 功能说明：孩子类, 具备各种动作, 具备心理状态
 * 逻辑分支方法
 * 如下这样的代码, 在面对新需求或者需求改变时候, 需要不断修改代码, 不符合开闭原则
 * 最好的方式: 使用状态模式, 将状态相关的状态和行为抽取到单独的类中
 * 开发人员：@author MaLi
 */
public class Child {
    private float temperatur = 36.7F;
    private boolean expression = true;
    private Mentality mentality = Mentality.HAPPY;


    public void sleep() {
        System.out.println("hu hu hu...");
        this.temperatur = 36.5F;
        this.expression = true;
        this.mentality = Mentality.COMMONLY;

    }

    public void eat() {
        System.out.println("bia bia bia...");
        this.temperatur = 36.8F;
        this.expression = true;
        this.mentality = Mentality.HAPPY;
    }

    public void loseSleep() {
        System.out.println("wa wa wa...");
        this.temperatur = 37.5F;
        this.expression = false;
        this.mentality = Mentality.ANGRY;
    }
}
