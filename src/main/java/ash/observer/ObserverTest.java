package ash.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/14 11:11 AM
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexObserver(subject);
        subject.setNum(2);
        subject.setNum(10);
    }
}

class Subject{

    private int num;
    private List<Observer> observers = new ArrayList<>();

    public int getNum() { return num; }
    public void setNum(int num) { this.num = num; updateAll(); }
    public void attach(Observer observer){ observers.add(observer); }
    public void updateAll(){
        for(Observer observer:observers){
            observer.update();
        }
    }
}
interface Observer{
    void update();
}
class BinaryObserver implements Observer{

    private Subject subject;

    public BinaryObserver(Subject subject) { this.subject = subject; this.subject.attach(this); }
    @Override
    public void update() {
        System.out.println("Binary : " + Integer.toBinaryString(subject.getNum()));
    }
}
class OctalObserver implements Observer{

    private Subject subject;

    public OctalObserver(Subject subject) { this.subject = subject; this.subject.attach(this); }
    @Override
    public void update() {
        System.out.println("Octal : " + Integer.toOctalString(subject.getNum()));
    }
}
class HexObserver implements Observer{

    private Subject subject;

    public HexObserver(Subject subject) { this.subject = subject; this.subject.attach(this); }
    @Override
    public void update() {
        System.out.println("Hex : " + Integer.toHexString(subject.getNum()));
    }
}
//Binary : 10
//Octal : 2
//Hex : 2
//Binary : 1010
//Octal : 12
//Hex : a