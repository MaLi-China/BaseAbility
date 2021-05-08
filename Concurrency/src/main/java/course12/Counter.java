package course12;

/**
 * 功能说明：面向对象的方式对并发编程的帮助
 * (1) 封装共享变量
 * (2) 对外提供访问共享变量的方法
 * <p>
 * 共享变量/但是不变化的定义为final
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/8
 */
public class Counter {
    private final String counterName;
    private long value;

    public Counter(String counterName) {
        this.counterName = counterName;
    }

    public synchronized void add() {
        value++;
    }

    public synchronized long get() {
        return value;
    }

}
