package demo5;

public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station, "小明").start();
        new Thread(station, "老师").start();
        new Thread(station, "黄牛党").start();
    }
}

class BuyTicket implements Runnable {

    private int ticketNmus = 10;
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(1000);
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // synchronized 同步方法
    private synchronized void buy() throws InterruptedException {
        if (ticketNmus <= 0) {
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "拿到" + (ticketNmus--) + "票");
    }
}
