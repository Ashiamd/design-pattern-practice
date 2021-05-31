package ash.decorator;

/**
 * 装饰器模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/5/31 10:17 PM
 */
public class DecoratorTest {
    public static void main(String[] args) {
        DaggerComponent dagger1 = new ShortDagger();
        DaggerComponent physicalDagger = new PhysicalDagger(dagger1);
        physicalDagger.stab();

        DaggerComponent dagger2 = new ShortDagger();
        DaggerComponent magicDagger = new MagicDagger(dagger2);
        magicDagger.stab();
    }
}

interface DaggerComponent{
    void stab();
}

abstract class DaggerDecorator implements DaggerComponent{
    private DaggerComponent daggerComponent;

    protected DaggerDecorator(DaggerComponent daggerComponent) { this.daggerComponent = daggerComponent; }

    @Override
    public void stab() { daggerComponent.stab(); }
}

class PhysicalDagger extends DaggerDecorator{
    public PhysicalDagger(DaggerComponent daggerComponent) { super(daggerComponent); }
    @Override
    public void stab() {
        super.stab();
        System.out.println("bleeding ... -1HP -1HP -1HP");
    }
}

class MagicDagger extends DaggerDecorator{
    public MagicDagger(DaggerComponent daggerComponent) { super(daggerComponent); }
    @Override
    public void stab() {
        super.stab();
        System.out.println("frozen ... you can't move");
    }
}

class ShortDagger implements DaggerComponent{
    @Override
    public void stab() { System.out.println("stab stab stab !!! -20HP"); }
}