package demo1;

// 创建线程方式二：实现runnable 接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
public class TestThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程" + i);
        }
    }

    public static void main(String[] args) {

        //创建runnable 接口的实行类对象
        TestThread2 testThread2 = new TestThread2();
        Thread thread = new Thread(testThread2);
        thread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程" + i);
        }
    }
}
