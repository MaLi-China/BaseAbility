package mchapter06;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：
 * N张火车票, 每张票有一个编号
 * 同时有10个窗口对外售票
 * 写一个模拟程序
 * 开发人员：@Author MaLi
 */
public class T02_TicketSaleWindow implements Runnable {

    // 火车票共享资源: 集合, 里面的火车票存在编号
    private int n;
    //    private List<String> tickets;
    private Vector<String> tickets;

    public T02_TicketSaleWindow(int n) {
        this.n = n;
//        this.tickets = Collections.synchronizedList(new ArrayList<String>(n));
        tickets = new Vector<>();
        for (int i = 0; i < n; i++) {
            this.tickets.add("TicktNo. :" + i);
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        // 买票线程: 在集合中取, 如何不超卖, 不重复卖
        while (tickets.size() > 0) {
            synchronized (this) {
                if (tickets.size() <= 0) {
                    break;
                }
                String ticket = tickets.remove(0);
                System.out.println("Window: " + Thread.currentThread().getName() + " --> No.: " + ticket);
                try {
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        int windowsAccount = 10;
        T02_TicketSaleWindow saleTicketTask = new T02_TicketSaleWindow(20);
        Thread[] windows = new Thread[windowsAccount];
        for (int i = 0; i < windowsAccount; i++) {
            windows[i] = new Thread(saleTicketTask);
        }
        for (Thread window : windows) {
            window.start();

        }
        for (Thread window : windows) {
            try {
                window.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
