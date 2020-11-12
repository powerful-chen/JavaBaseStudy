package demo5;

//化妆
public class DeadLock {
    public static void main(String[] args) {

        Makeup g1 = new Makeup(0, "灰姑娘");
        Makeup g2 = new Makeup(1, "白雪公主");
        g1.start();
        g2.start();
    }
}

// 口红
class Lipstick {

}

// 镜子
class Mirror {

}

class Makeup extends Thread {

    // 需要的资源只有一份，用static来保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;// 选择
    String girlName; // 使用化妆品的人

    Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {// 获取口红
                System.out.println(this.girlName + "获取口红");
            }
            Thread.sleep(1000);
            synchronized (mirror) {
                System.out.println(this.girlName + "获取镜子");
            }
        } else {
            synchronized (mirror) {// 获取口红
                System.out.println(this.girlName + "获取镜子");
            }
            Thread.sleep(1000);
            synchronized (lipstick) {
                System.out.println(this.girlName + "获取口红");
            }
        }
    }
}