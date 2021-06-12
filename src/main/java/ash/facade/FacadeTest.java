package ash.facade;

/**
 * 外观模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/12 7:08 PM
 */
public class FacadeTest {
    public static void main(String[] args) {
        ShapeFacade shapeFacade = new ShapeFacade();
        shapeFacade.drawRectangle();
        shapeFacade.drawCircle();
        shapeFacade.drawTriangle();
    }
}

class ShapeFacade{
    private Rectangle rectangle;
    private Circle circle;
    private Triangle triangle;

    public ShapeFacade() {
        this.rectangle = new Rectangle();
        this.circle = new Circle();
        this.triangle = new Triangle();
    }

    public void drawRectangle(){rectangle.draw();}
    public void drawCircle(){circle.draw();}
    public void drawTriangle(){triangle.draw();}
}
interface MyShape{
    void draw();
}
class Rectangle implements MyShape{
    @Override
    public void draw() { System.out.println("draw rectangle ~ "); }
}
class Circle implements MyShape{
    @Override
    public void draw() { System.out.println("draw circle ~ "); }
}
class Triangle implements MyShape{
    @Override
    public void draw() { System.out.println("draw triangle ~ "); }
}