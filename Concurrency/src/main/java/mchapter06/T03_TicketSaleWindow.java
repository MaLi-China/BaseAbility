package mchapter06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：M张票, N个窗口卖票, 不超卖, 不重复
 * 开发人员：@Author MaLi
 */
public class T03_TicketSaleWindow implements Runnable {
    private List<String> tickets;
    private int ticketAmount;
    private int windowAmount;

    public T03_TicketSaleWindow(int ticketAmount, int windowAmount) {
        this.ticketAmount = ticketAmount;
        this.tickets = new ArrayList<>(this.ticketAmount);
        this.windowAmount = windowAmount;
        for (int i = 1; i <= ticketAmount; i++) {
            tickets.add("TicketNo: " + i);
        }
    }

    @Override
    public void run() {
        //卖票任务
        while (tickets.size() > 0) {
            synchronized (this) {
                if (tickets.size() == 0) {
                    break;
                }
                String ticket = tickets.remove(0);
                System.out.println(Thread.currentThread().getName() + " 卖出 " + ticket);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void startSale(T03_TicketSaleWindow ticketSaleWindow) {
        ArrayList<Thread> windows = new ArrayList<>();
        for (int i = 0; i < ticketSaleWindow.windowAmount; i++) {
            Thread window = new Thread(ticketSaleWindow);
            windows.add(window);
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

    public static void main(String[] args) {
        T03_TicketSaleWindow ticketSaleWindow = new T03_TicketSaleWindow(100, 10);
        ticketSaleWindow.startSale(ticketSaleWindow);
    }
}
