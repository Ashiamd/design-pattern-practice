package ash.singleton;

import java.io.*;

/**
 * 双重检查
 * 优点：
 *  1. 线程安全
 *  2. 延迟加载
 * 缺点：
 *  1. 实现较复杂
 *  2. 需要自行防止反射破解单例实现
 *  3. 需要自行防止序列化破解单例实现
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/5/29 2:51 PM
 */
public class Singleton002 implements Serializable {

    private static volatile Singleton002 INSTANCE;

    private Singleton002(){
        // 针对 2.反射破解单例 的解决方案
        // 加以下代码后，若尝试通过反射破解单例，则抛出异常
        /*if(INSTANCE!=null){
            throw new RuntimeException("尝试通过反射破解单例");
        }*/
    }

    public static Singleton002 getInstance(){
        if(null == INSTANCE){
            synchronized (Singleton002.class){
                if(null == INSTANCE){
                    INSTANCE = new Singleton002();
                }
            }
        }
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
        // 'Singleton002()' has private access in 'ash.singleton.Singleton002'
        // Singleton002 instance = new Singleton002();
        Singleton002 instance01 = Singleton002.getInstance();
        Singleton002 instance02 = Singleton002.getInstance();
        System.out.println(instance01==instance02); // true
    }
}*/

// 2. 测试 是否能够通过反射破解单例
/*class Test02 {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("ash.singleton.Singleton002");
        Constructor constructor = clazz.getDeclaredConstructor();

        constructor.setAccessible(true);

        Singleton002 instance01 = Singleton002.getInstance();
        Singleton002 instance02 = Singleton002.getInstance();
        Singleton002 instance03 = (Singleton002) constructor.newInstance();
        Singleton002 instance04 = (Singleton002) constructor.newInstance();

        System.out.println(instance01 == instance02); // true
        System.out.println(instance02 == instance03); // false
        System.out.println(instance03 == instance04); // false
    }
}*/

// 3. 测试 是否能够通过序列化/反序列化破解单例
/*class Test03 {
    public static void main(String[] args) throws Exception {
        Singleton002 instance001 = Singleton002.getInstance();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("Singleton.txt")
        );
        objectOutputStream.writeObject(instance001);
        objectOutputStream.flush();
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("Singleton.txt")
        );
        Singleton002 instance002 = (Singleton002) objectInputStream.readObject();

        System.out.println(instance001); // ash.singleton.Singleton002@5f150435
        System.out.println(instance002); // ash.singleton.Singleton002@2c6a3f77
        System.out.println(instance001 == instance002); // false
    }
}*/
