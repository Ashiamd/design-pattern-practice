package ash.templatemethod;

/**
 * 模版方法模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/13 7:03 PM
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        Game rpg = new RPG();
        Game moba = new MOBA();
        rpg.play();
        moba.play();
    }
}

abstract class Game{
    abstract protected void init();
    abstract protected void start();
    abstract protected void end();
    public final void play(){
        init();
        start();
        end();
    }
}

class RPG extends Game{
    @Override
    protected void init() { System.out.println(" RPG init ~ "); }
    @Override
    protected void start() { System.out.println(" RPG start ~ "); }
    @Override
    protected void end() { System.out.println(" RPG end ~ "); }
}

class MOBA extends Game{
    @Override
    protected void init() { System.out.println(" MOBA init ~ "); }
    @Override
    protected void start() { System.out.println(" MOBA start ~ "); }
    @Override
    protected void end() { System.out.println(" MOBA end ~ "); }
}