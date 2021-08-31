package mchapter06;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：使用更高效的ConcurrentLinkedDeque
 * 开发人员：@Author MaLi
 */
public class T04_TicketSalWindow {
    private Queue<String> tickets = new ConcurrentLinkedDeque<>(); // 使用队列实现售票模拟
    private int ticketAmount;
    private int windowAmount;

    public T04_TicketSalWindow(int ticketAmount, int windowAmount) {
        this.ticketAmount = ticketAmount;
        this.windowAmount = windowAmount;
        for (int i = 0; i < this.ticketAmount; i++) {
            tickets.offer("TicketNo: " + i);
        }
    }

    public void sale() {
        Thread[] windows = new Thread[windowAmount];
        for (int i = 0; i < windowAmount; i++) {
            Thread window = new Thread(() -> {
                while (tickets.size() > 0) {
                    String ticket = tickets.poll();
                    System.out.println(Thread.currentThread().getName() + " sale -->" + ticket);
                    try {
                        TimeUnit.MILLISECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Window_" + i);
            windows[i] = window;
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
        T04_TicketSalWindow salWindow = new T04_TicketSalWindow(100, 10);
        salWindow.sale();
    }
}
