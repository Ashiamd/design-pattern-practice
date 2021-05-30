package ash.adapter;

/**
 * 对象适配器
 * 依赖(聚合/组合)被适配的类，实现目标接口
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/5/30 9:11 PM
 */
public class ObjectAdapter {
    public static void main(String[] args) {
        Phone phone = new Phone();
        VoltageAdapter voltageAdapter = new VoltageAdapter();
        voltageAdapter.voltage220VAdapter(new Voltage220V());
        phone.charge(voltageAdapter);
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

class VoltageAdapter implements Voltage5V{

    Voltage220V voltage220V;

    void voltage220VAdapter(Voltage220V voltage220V){
        this.voltage220V = voltage220V;
    }

    @Override
    public void output5V() {
        voltage220V.output220V();
        System.out.println("adapter ~ 220v => 5v");
        System.out.println("output ~ 5v");
    }
}