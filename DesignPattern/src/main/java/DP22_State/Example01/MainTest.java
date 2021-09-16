package DP22_State.Example01;

/**
 * 功能说明：测试状态模式的案例
 * 状态模式作用: 对象的行为依赖与它的属性/状态变化
 * 开发人员：@author MaLi
 */
public class MainTest {
    public static void main(String[] args) {
        // 封装状态
        Context context = new Context();
        StartState startState = new StartState();
        //状态改变 --> 引起对象行为变化
        startState.doAction(context);
        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        //状态改变 --> 引起对象行为变化
        stopState.doAction(context);
        System.out.println(context.getState().toString());
    }
}
