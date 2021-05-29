package ash.prototype;

/**
 * 原型模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/5/29 10:35 PM
 */
public abstract class Pattern implements Cloneable{

    protected String shape;

    abstract void draw();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Circle extends Pattern{
    public Circle() { shape = "circle"; }
    @Override
    void draw() { System.out.println("draw ~ "+shape); }
}

class Rectangle extends Pattern{
    public Rectangle() { shape = "rectangle"; }
    @Override
    void draw() { System.out.println("draw ~ "+shape); }
}

class Test{
    public static void main(String[] args) throws CloneNotSupportedException {
        Pattern circle = new Circle();
        Pattern rectangle = new Rectangle();
        circle.draw();
        rectangle.draw();

        Pattern anotherCircle = (Pattern) circle.clone();
        Pattern anotherRectangle = (Pattern) rectangle.clone();

        anotherCircle.draw();
        anotherRectangle.draw();

        System.out.println(circle == anotherCircle); // false
        System.out.println(rectangle == anotherRectangle); // false
    }
}