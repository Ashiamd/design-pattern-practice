package ash.builder;

/**
 * 建造者模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/5/29 11:42 PM
 */
public abstract class GetUpBuilder {
    abstract void brushTeeth();
    abstract void washFace();
    abstract void wearShoes();
}

class Director{
    private GetUpBuilder builder;
    public Director(GetUpBuilder builder) { this.builder = builder; }
    public void getUp(){
        builder.brushTeeth();
        builder.washFace();
        builder.wearShoes();
    }
}

class MeBuilder extends GetUpBuilder{
    @Override
    void brushTeeth() { System.out.println("me => brush teeth => 3 min"); }
    @Override
    void washFace() { System.out.println("me => wash face => 4 min"); }
    @Override
    void wearShoes() { System.out.println("me => wear shoes => 2 min"); }
}

class SomeoneBuilder extends GetUpBuilder{
    @Override
    void brushTeeth() { System.out.println("someone => brush teeth => 2 min"); }
    @Override
    void washFace() { System.out.println("someone => wash face => 2 min"); }
    @Override
    void wearShoes() { System.out.println("someone => wear shoes => 1 min"); }
}

class Test{
    public static void main(String[] args) {
        GetUpBuilder meBuilder = new MeBuilder();
        GetUpBuilder someoneBuilder = new SomeoneBuilder();

        Director meDirector = new Director(meBuilder);
        Director someoneDirector = new Director(someoneBuilder);

        meDirector.getUp();
        someoneDirector.getUp();
    }
}