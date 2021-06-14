package ash.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 策略模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/14 7:54 PM
 */
public class StrategyTest {
    public static void main(String[] args) {
        Context context = new Context();
        context.addStrategy(new FlyStrategy());
        context.addStrategy(new RunStrategy());
        context.addStrategy(new SwimStrategy());
        context.handle("run");
        context.handle("fly");
        context.handle("swim");
        context.handle("cycle");
    }
}

interface Strategy{
    boolean isOwn(String pattern);
    void handle();
}
class Context{
    private List<Strategy> strategies = new ArrayList<>();
    public void addStrategy(Strategy strategy){this.strategies.add(strategy);}
    public void handle(String pattern){
        for(Strategy strategy:strategies){
            if(strategy.isOwn(pattern)){
                strategy.handle();
                return;
            }
        }
        System.out.println("no eligible strategy ～ ");
    }
}
class FlyStrategy implements Strategy{
    @Override
    public boolean isOwn(String pattern) { return "fly".equals(pattern); }
    @Override
    public void handle() { System.out.println("fly ~ "); }
}
class RunStrategy implements Strategy{
    @Override
    public boolean isOwn(String pattern) { return "run".equals(pattern); }
    @Override
    public void handle() { System.out.println("run ~ "); }
}
class SwimStrategy implements Strategy{
    @Override
    public boolean isOwn(String pattern) { return "swim".equals(pattern); }
    @Override
    public void handle() { System.out.println("swim ~ "); }
}
//run ~
//fly ~
//swim ~
//no eligible strategy ～