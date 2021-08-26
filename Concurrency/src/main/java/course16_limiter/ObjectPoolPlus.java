package course16_limiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 功能说明：实现一个对象池
 * 开发人员：@Author MaLi
 */
public class ObjectPoolPlus<T, R> {
    private List<T> pool;
    private int size;
    private Semaphore lock;

    private ObjectPoolPlus() {
    }

    public ObjectPoolPlus(int size, Object t) {
        this.size = size;
        pool = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            try {
                T instance = (T) t.getClass().newInstance();
                pool.add(instance);
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }
        lock = new Semaphore(size, true);
    }

    public R execute(Function<T, R> function) {
        R result = null;
        T obj = null;
        try {
            lock.acquire();
            obj = pool.remove(0);
            result = function.apply(obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pool.add(obj);
            lock.release();
        }
        return result;
    }
}
