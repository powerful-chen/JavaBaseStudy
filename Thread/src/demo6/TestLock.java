package demo6;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock implements Runnable {
    // 票数
    private int ticketNum = 10;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            lock.lock();
            while (true) {
                if (ticketNum <= 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNum-- + "票");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        demo1.TestThread3 ticket = new demo1.TestThread3();

        new Thread(ticket, "小明").start();
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛").start();
    }
}

