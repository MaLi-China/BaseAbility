package course12;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 功能说明：识别共享变量间的约束条件
 * 竟态条件: 程序的执行结果依赖线程执行的顺序; 程序的执行依赖某个状态变量;
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/8
 */
public class SafeWM {

    private final AtomicLong upper = new AtomicLong(0);
    private final AtomicLong lower = new AtomicLong(0);

    public synchronized void setUpper(long v) {
        if (v < this.lower.get()) {
            throw new IllegalArgumentException("参数低于库存下限:" + lower);
        }
        upper.set(v);
    }

    public synchronized void setLower(long v) {
        if (v > this.upper.get()) {
            throw new IllegalArgumentException("参数高于库存上限" + upper);
        }
        lower.set(v);
    }
}
