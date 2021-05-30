package ash.adapter;

/**
 * 接口适配器
 * 提供抽象类/接口的空实现，按照自己实际需求重写
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/5/30 9:23 PM
 */
public class InterfaceAdapter {
    public static void main(String[] args) {
        Player triathlonPlayer = new TriathlonPlayer();
        triathlonPlayer.fight();
        Player marathonPlayer = new MarathonPlayer();
        marathonPlayer.fight();
    }
}

interface Player{
    void swim();
    void cycle();
    void run();
    void fight();
}

abstract class TriathlonPlayerAdapter implements Player{
    @Override
    public void swim() {}
    @Override
    public void cycle() {}
    @Override
    public void run() {}
    @Override
    public void fight(){
        System.out.println("Triathlon ~ Fighting !");
        swim();
        cycle();
        run();
    }
}

abstract class MarathonPlayerAdapter implements Player{
    @Override
    public void swim() {}
    @Override
    public void cycle() {}
    @Override
    public void run() {}
    @Override
    public void fight(){
        System.out.println("Marathon ~ Fighting !");
        run();
    }
}

class TriathlonPlayer extends TriathlonPlayerAdapter {
    public TriathlonPlayer() {
        System.out.println("Sorry, I'm Superman.");
    }
    @Override
    public void swim() {
        System.out.println("swim ~ 999 km/s");
    }
    @Override
    public void cycle() {
        System.out.println("cycle ~ 998 km/s");
    }
    @Override
    public void run() {
        System.out.println("run ~ 997 km/s");
    }
}

class MarathonPlayer extends MarathonPlayerAdapter{
    public MarathonPlayer() {
        System.out.println("Sorry, I'm SSSSSSuperman.");
    }

    @Override
    public void run() {
        System.out.println("run ~ !@#$%^& km/s");
    }
}