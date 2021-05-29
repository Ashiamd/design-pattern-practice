package ash.singleton;

import javafx.beans.binding.ObjectExpression;

import java.io.*;

/**
 * 饿汉式(静态常量)
 * 优点：线程安全
 * 缺点：
 * 1. 类加载时就初始化(没有懒加载效果)
 * 2. 需要自行防止反射破解单例实现
 * 3. 需要自行防止序列化破解单例实现
 *
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/5/29 8:34 AM
 */
public class Singleton001 implements Serializable {

    private static final Singleton001 INSTANCE = new Singleton001();

    private Singleton001() {
        // 针对 2.反射破解单例 的解决方案
        // 加以下代码后，若尝试通过反射破解单例，则抛出异常
        /*if(INSTANCE!=null){
            throw new RuntimeException("尝试通过反射破解单例");
        }*/
    }

    public static Singleton001 getInstance() {
        return INSTANCE;
    }

    // 针对 3.序列化/反序列化破解单例 的解决方案
    // 若存在该readResolve() 方法，则反序列化时直接返回INSTANCE，不会新建对象
    /*private Object readResolve() throws ObjectStreamException{
        return INSTANCE;
    }*/

}

// 1. 测试 单例类实现
/*class Test01 {
    public static void main(String[] args) {
        // 'Singleton001()' has private access in 'ash.singleton.Singleton001'
        // Singleton001 instance = new Singleton001();
        Singleton001 instance01 = Singleton001.getInstance();
        Singleton001 instance02 = Singleton001.getInstance();
        System.out.println(instance01==instance02); // true
    }
}*/

// 2. 测试 是否能够通过反射破解单例
/*class Test02 {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("ash.singleton.Singleton001");
        Constructor constructor = clazz.getDeclaredConstructor();

        constructor.setAccessible(true);

        Singleton001 instance01 = Singleton001.getInstance();
        Singleton001 instance02 = Singleton001.getInstance();
        Singleton001 instance03 = (Singleton001) constructor.newInstance();
        Singleton001 instance04 = (Singleton001) constructor.newInstance();

        System.out.println(instance01 == instance02); // true
        System.out.println(instance02 == instance03); // false
        System.out.println(instance03 == instance04); // false
    }
}*/

// 3. 测试 是否能够通过序列化/反序列化破解单例
/*
class Test03 {
    public static void main(String[] args) throws Exception {
        Singleton001 instance001 = Singleton001.getInstance();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("Singleton.txt")
        );
        objectOutputStream.writeObject(instance001);
        objectOutputStream.flush();
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("Singleton.txt")
        );
        Singleton001 instance002 = (Singleton001) objectInputStream.readObject();

        System.out.println(instance001); // ash.singleton.Singleton001@5f150435
        System.out.println(instance002); // ash.singleton.Singleton001@2c6a3f77
        System.out.println(instance001 == instance002); // false
    }
}*/
