package Chapter12_ClassLoader;

/**
 * 功能说明：三种不同运行模式下的执行效率
 * 解释执行: -Xint          result=...ms(多半分钟没看到结果, 小马哥不看了)
 * 编译执行: -Xcomp         result=40ms
 * 混合执行: -Xmixed        result=9ms
 * 开发人员：@author MaLi
 */
public class T03_RunningMode {
    //定义执行循环的次数
    private static int _1Million = 1000000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int mainResult = 0;
        //循环调用100万次 doSom()函数
        for (int i = 0; i < _1Million; i++) {
            mainResult += doSom();
        }
        System.out.println(mainResult);
        long end = System.currentTimeMillis();
        System.out.println("Time wasted: " + (end - start) + "ms");
    }

    public static int doSom() {
        int result = 0;
        //计算100万次加法
        for (int i = 0; i < _1Million; i++) {
            result++;
        }
        return result;
    }
}
