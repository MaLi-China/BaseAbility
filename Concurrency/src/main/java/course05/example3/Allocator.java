package course05.example3;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：
 * 单例对象, 分配锁
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/7
 */
public class Allocator {
    private static List<Object> locks = new ArrayList<>();

    /**
     * 申请锁
     *
     * @param from 申请转出账户的锁
     * @param to   申请转入胀库的锁
     * @return 代表申请成功的标记
     */
    public synchronized static boolean apply(Object from, Object to) {
        boolean flag = false;
        if (!locks.contains(from) && !locks.contains(to))
            flag = true;
        return flag;
    }

    /**
     * 释放锁资源
     *
     * @param from 释放转出账户的锁
     * @param to   释放转入账户的锁
     */
    public synchronized static void free(Object from, Object to) {
        locks.remove(from);
        locks.remove(to);
    }
}
