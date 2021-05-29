package ash.abstractfactory;

/**
 * 抽象工厂模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/5/29 9:25 PM
 */
public interface HardwareFactory {
    Keyboard produceKeyboard();
    Mouse produceMouse();
}

class LogitechFactory implements HardwareFactory{
    @Override
    public Keyboard produceKeyboard() { return new LogitechKeyboard(); }
    @Override
    public Mouse produceMouse() { return new LogitechMouse(); }
}

class RazerFactory implements HardwareFactory{
    @Override
    public Keyboard produceKeyboard() { return new RazerKeyboard(); }
    @Override
    public Mouse produceMouse() { return new RazerMouse(); }
}

interface Keyboard{ void type(); }

interface Mouse{ void click(); }

class LogitechKeyboard implements Keyboard{
    @Override
    public void type() { System.out.println("logitech ~ keyboardddddd");  }
}

class LogitechMouse implements Mouse{
    @Override
    public void click() {System.out.println("logitech ~ mouseeeeee"); }
}

class RazerKeyboard implements Keyboard{
    @Override
    public void type() { System.out.println("razer ~ keyboard"); }
}

class RazerMouse implements Mouse{
    @Override
    public void click() { System.out.println("razer ~ mouse"); }
}

class Test{
    public static void main(String[] args) {
        HardwareFactory logitechFactory = new LogitechFactory();
        HardwareFactory razerFactory = new RazerFactory();

        Keyboard logitechKeyboard = logitechFactory.produceKeyboard();
        Mouse logitechMouse = logitechFactory.produceMouse();

        Keyboard razerKeyboard = razerFactory.produceKeyboard();
        Mouse razerMouse = razerFactory.produceMouse();

        logitechKeyboard.type();
        logitechMouse.click();

        razerKeyboard.type();
        razerMouse.click();
    }
}