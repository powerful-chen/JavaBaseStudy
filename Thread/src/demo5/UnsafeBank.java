package demo5;

public class UnsafeBank {
    public static void main(String[] args) {

        Account account = new Account(1000, "结婚基金");

        Drawing you = new Drawing(account, 50, "you");
        Drawing girlFriend = new Drawing(account, 100, "girlFriend");

        you.start();
        girlFriend.start();
    }
}

class Account {
    int money; // 余额
    String name; // 卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {

    Account account;//账户

    int drawingMoney;//取走的钱

    int nowMoney;

    String name;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        synchronized (account) {
            // 判断有没有钱
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
                return;
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 卡内余额
            account.money = account.money - drawingMoney;

            // 你手上的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name + "余额为" + account.money);
            System.out.println(Thread.currentThread().getName() + "手里的钱" + nowMoney);
        }

    }
}