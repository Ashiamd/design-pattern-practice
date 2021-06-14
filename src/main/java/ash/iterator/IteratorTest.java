package ash.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/14 10:15 AM
 */
public class IteratorTest {
    public static void main(String[] args) {
        StringContainer container = new StringContainer();
        container.addString("str_1");
        container.addString("str_2");
        container.addString("str_3");
        for(Iterator iterator = container.getIterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }
}

interface Container{
    Iterator getIterator();
}
interface Iterator{
    boolean hasNext();
    Object next();
}
class StringContainer implements Container{
    List<String> container = new ArrayList<>();

    public void addString(String str){ container.add(str); }

    @Override
    public Iterator getIterator() { return new StringIterator(); }

    private class StringIterator implements Iterator{

        private int index;

        @Override
        public boolean hasNext() {
            return index < container.size();
        }
        @Override
        public Object next() {
            if(this.hasNext()){
                return container.get(index++);
            }
            return null;
        }
    }
}