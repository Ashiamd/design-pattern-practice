package ash.memento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 备忘录模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/14 3:10 PM
 */
public class MementoTest {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        originator.setState("state - 1");
        caretaker.saveMemento(originator, originator.saveStateToMemento());
        originator.setState("state - 2");
        caretaker.saveMemento(originator, originator.saveStateToMemento());
        originator.setState("state - 3");
        System.out.println(originator.getState());
        caretaker.saveMemento(originator, originator.saveStateToMemento());
        originator.getStateFromMemento(caretaker.getMemento(originator,0));
        System.out.println(originator.getState());
        originator.getStateFromMemento(caretaker.getMemento(originator,1));
        System.out.println(originator.getState());
        originator.getStateFromMemento(caretaker.getMemento(originator,2));
        System.out.println(originator.getState());
    }
}
class Originator{
    private String state;

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public void getStateFromMemento(Memento memento){this.state = memento.getState();}
    public Memento saveStateToMemento(){return new Memento(this.state);}
}
class Memento{
    private String state;

    public Memento(String state) { this.state = state; }
    public String getState() { return state; }
}
class Caretaker{
    HashMap<Originator, List<Memento>> mementoMap;

    public Caretaker() { this.mementoMap = new HashMap<>(); }
    public Memento getMemento(Originator originator,int index){return mementoMap.get(originator).get(index);}
    public void saveMemento(Originator originator,Memento memento){
        List<Memento> mementos = mementoMap.getOrDefault(originator, new ArrayList<>());
        mementos.add(memento);
        mementoMap.put(originator,mementos);
    }
}
//state - 3
//state - 1
//state - 2
//state - 3