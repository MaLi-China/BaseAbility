package DP02_Strategy;

/**
 * 功能说明：自定义的比较器, 作为策略传递进去.
 * 开发人员：@author MaLi
 */
public interface Comparator<T> {
    /**
     * @param o1 this
     * @param o2 与this比较的对象
     * @return 大于返回正数, 小于返回负数, 等于返回0
     */
    int compareTo(T o1, T o2);
}
