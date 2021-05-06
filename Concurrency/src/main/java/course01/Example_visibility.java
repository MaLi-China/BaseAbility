package course01;

/**
 * 功能说明：
 * 1, 验证多核场景下的可见性问题
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/4
 */
public class Example_visibility {

    private long number = 0;

    /*
        使用synchronized保证原子性和可见性
           可见性: happen-before 线程锁规则: 线程对临界区的解锁, 先于线程对临界区的加锁;
           根据传递性规则: 在临界区对共享变量的写, 先于解锁与加锁之后对共享变量的读;
           原子性: 对共享变量的读写操作加锁
     */
    public synchronized void add10K() {
        int time = 0;
        while (time++ < 10000) {
            number++;
        }
    }

    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger(Example_visibility.class);
        try {
            Example_visibility action = new Example_visibility();
            Thread thread_1 = new Thread(() -> action.add10K());
            Thread thread_2 = new Thread(() -> action.add10K());
            thread_1.start();
            thread_2.start();
            thread_1.join();
            thread_2.join();
            System.out.println("计算结果: " + action.number);
//            logger.info("计算结果: " + action.number);
        } catch (InterruptedException e) {
            e.printStackTrace();
//            logger.error(e.getMessage(),e);
        } catch (ArithmeticException e) {
            e.printStackTrace();
//            logger.error(e.getMessage(),e);
        }
    }
}
