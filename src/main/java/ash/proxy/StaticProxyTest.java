package ash.proxy;

/**
 * 代理模式 - 静态代理
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/13 3:38 PM
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        StaticProxy robot = new Robot(new Me("ashiamd"));
        robot.doSomething();
    }
}

interface StaticProxy{
    void doSomething();
}

class Me implements StaticProxy{
    String name;
    @Override
    public String toString() { return name; }
    public Me(String name) { this.name = name; }
    @Override
    public void doSomething() { System.out.println(name + " sleep ~"); }
}

class Robot implements StaticProxy{
    StaticProxy someone;
    public Robot(StaticProxy someone) { this.someone = someone; }
    @Override
    public void doSomething() {
        someone.doSomething();
        System.out.println("Robot help "+ someone +" to work");
    }
}
