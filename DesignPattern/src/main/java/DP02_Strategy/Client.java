package DP02_Strategy;

/**
 * 功能说明：客户端类, 提供比较方法
 * 开发人员：@author MaLi
 */
public class Client<T> {
    // 使用策略模式, 使用者传递进去.
    public void sort(T[] arrs, Comparator<T> comparator) {
        if (arrs.length == 0) return;
        //排序算法
        for (int i = 0; i < arrs.length - 1; i++) {
            for (int j = i + 1; j < arrs.length; j++) {
                T min = arrs[i];
                if (comparator.compareTo(arrs[i], arrs[j]) < 0) {
                    arrs[i] = arrs[j];
                    arrs[j] = min;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        Client<Integer> client = new Client<>();
        client.sort(nums, (o1, o2) -> o1 - o2);
        for (Integer num : nums) {
            System.out.println(num);
        }
    }
}
