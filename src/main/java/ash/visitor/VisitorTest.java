package ash.visitor;

/**
 * 访问者模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/13 8:18 PM
 */
public class VisitorTest {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        Element firstElement = new FirstElement();
        Element secondElement = new SecondElement();
        firstElement.accept(visitor);
        secondElement.accept(visitor);
    }
}
interface Element{
    void accept(Visitor visitor);
}
class FirstElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        System.out.println("First ~ ");
        visitor.visitFirstElement(this);
    }
}
class SecondElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        System.out.println("Second ~ ");
        visitor.visitSecondElement(this);
    }
}
interface Visitor{
    void visitFirstElement(FirstElement firstElement);
    void visitSecondElement(SecondElement secondElement);
}
class ConcreteVisitor implements Visitor{
    @Override
    public void visitFirstElement(FirstElement firstElement) {
        System.out.println("visit firstElement ~ ");
    }
    @Override
    public void visitSecondElement(SecondElement secondElement) {
        System.out.println("visit secondElement ~ ");
    }
}