package demo2;
// 静态代理总结：
// 真实对象和代理对象都要实现同一个接口
// 代理对象要代理真实角色

// 好处：
//代理对象可以做很多真实对象做不了的事情
//真实对象专注做自己的事情
public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();

        new Thread(() -> System.out.println("I love you 淳淳")).start();

        WeddingCompany weddingCompany = new WeddingCompany(you);
        weddingCompany.HappyMarry();
    }


}

interface Marry {
    void HappyMarry();
}

// 真实角色，你去结婚
class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("我今天娶了淳淳我好开心呀！");
    }
}

// 代理角色，帮助你结婚
class WeddingCompany implements Marry {
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后，开开心心每一天！");
    }

    private void before() {
        System.out.println("结婚之前，布置现场！");
    }
}
