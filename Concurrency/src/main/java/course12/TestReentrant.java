package course12;

/**
 * 功能说明：测试synchronized是否可以重入
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/8
 */
public class TestReentrant {
    private long count = 0;

    public synchronized void execute() {
        count++;
    }

    public synchronized void run() {
        for (int i = 0; i < 100; i++) {
            execute();
        }
        System.out.println(this.count);
    }

    public static void main(String[] args) {
        TestReentrant reentrant = new TestReentrant();
        reentrant.run();
    }
}
