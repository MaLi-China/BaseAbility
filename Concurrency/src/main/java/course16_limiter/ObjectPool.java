package course16_limiter;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 功能说明：限流器实现 - 信号量实现
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/10
 */
public class ObjectPool<T, R> {
    public final int size;
    public final List<T> pool;
    public final Semaphore sem;

    public ObjectPool(int size, T t) {
        this.size = size;
        // 如果这里换成ArrayList: 会造成多线程操作ArrayList, 产生线程安全问题
        pool = new Vector<>();
        for (int i = 0; i < size; i++) {
            //初始化资源为可用状态
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    public R execute(Function<T, R> func) {
        T t = null;
        try {
            // 信号通过, 则放行; 否则, 阻塞在这里.
            sem.acquire();
            t = pool.remove(0);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pool.add(t);
            sem.release();
        }
        return func.apply(t);
    }
}
