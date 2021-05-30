package ash.adapter;

/**
 * 类适配器
 * 继承被适配的类，实现目标接口
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/5/30 8:13 PM
 */
public class ClassAdapter {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charge(new VoltageAdapter());
    }
}

interface Voltage5V{
    void output5V();
}

class Phone{
    void charge(Voltage5V voltage5V){
        voltage5V.output5V();
        System.out.println("phone ~ charging");
    }
}

class Voltage220V{
    void output220V(){
        System.out.println("output ~ 220v");
    }
}

class VoltageAdapter extends Voltage220V implements Voltage5V{
    @Override
    public void output5V() {
        output220V();
        System.out.println("adapter ~ 220v => 5v");
        System.out.println("output ~ 5v");
    }
}