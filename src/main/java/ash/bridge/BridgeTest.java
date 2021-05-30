package ash.bridge;

/**
 * 桥接模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/5/30 10:50 PM
 */
public class BridgeTest {
    public static void main(String[] args) {
        Graphics redRectangle = new Rectangle(new Red());
        Graphics greenRectangle = new Rectangle(new Green());
        Graphics redCircle = new Circle(new Red());
        Graphics greenCircle = new Circle(new Green());

        redRectangle.draw();
        greenRectangle.draw();
        redCircle.draw();
        greenCircle.draw();
    }
}

interface Graphics{
    void draw();
}

abstract class Shape implements Graphics{
    protected Color color;
    protected void setColor(Color color) { this.color = color; }
    abstract void drawBorder();
}

interface Color{
    void coloring();
}

class Rectangle extends Shape{
    public Rectangle(Color color) { setColor(color); }

    @Override
    void drawBorder() { System.out.println("draw rectangle"); }

    @Override
    public void draw() {
        drawBorder();
        color.coloring();
    }
}

class Circle extends Shape{
    public Circle(Color color) { setColor(color); }

    @Override
    void drawBorder() { System.out.println("draw circle"); }

    @Override
    public void draw() {
        drawBorder();
        color.coloring();
    }
}

class Green implements Color{
    @Override
    public void coloring() { System.out.println("color green"); }
}

class Red implements Color{
    @Override
    public void coloring() { System.out.println("color red"); }
}