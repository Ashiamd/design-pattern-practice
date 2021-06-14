package ash.state;

/**
 * 状态模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/14 6:56 PM
 */
public class StateTest {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new FirstState());
        context.request();
        context.request();
        context.request();
    }
}

class Context{
    private State state;
    public void setState(State state) { this.state = state; }
    public void request(){ this.state.handle(this); }
}
interface State{
    void handle(Context context);
}
class FirstState implements State{
    @Override
    public void handle(Context context) {
        System.out.println("first state ~ handle , next state is second state");
        context.setState(new SecondState());
    }
}
class SecondState implements State{
    @Override
    public void handle(Context context) {
        System.out.println("second state ~ handle , next state is third state");
        context.setState(new ThirdState());
    }
}
class ThirdState implements State{
    @Override
    public void handle(Context context) {
        System.out.println("third state ~ handle , next state is null");
        context.setState(null);
    }
}
//first state ~ handle , next state is second state
//second state ~ handle , next state is third state
//third state ~ handle , next state is null