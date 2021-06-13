package ash.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/13 7:33 PM
 */
public class CommandTest {
    public static void main(String[] args) {
        Number number = new Number();
        Broker broker = new Broker();
        broker.addCommand(new AddOneCommand(number));
        broker.addCommand(new SubtractOneCommand(number));
        broker.executeAll();
    }
}
class Broker{
    List<Command> commandList;
    public Broker() { this.commandList = new ArrayList<>(); }
    public void executeAll(){
        for(Command command : commandList){
            command.execute();
        }
    }
    public void addCommand(Command command){commandList.add(command);}
}
interface Command{
    void execute();
}
class Number{
    void addOne(){ System.out.println("+1"); }
    void subtractOne(){ System.out.println("-1"); }
}
class AddOneCommand implements Command{
    Number number;
    public AddOneCommand(Number number) { this.number = number; }
    @Override
    public void execute() { number.addOne(); }
}
class SubtractOneCommand implements Command{
    Number number;
    public SubtractOneCommand(Number number) { this.number = number; }
    @Override
    public void execute() { number.subtractOne(); }
}
