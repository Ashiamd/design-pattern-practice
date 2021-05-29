package ash.singleton;

import java.io.Serializable;

/**
 * 静态内部类
 * 优点：
 *  1. 线程安全
 *  2. 懒加载
 * 缺点：
 *  1. 需要自行防止反射破解单例实现
 *  2. 需要自行防止序列化破解单例实现
 *
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/5/29 3:06 PM
 */
public class Singleton003 implements Serializable {

    private Singleton003() {
        // 针对 1.反射破解单例 的解决方案
        // 加以下代码后，若尝试通过反射破解单例，则抛出异常
        /*if(null != Singleton.INSTANCE){
            throw new RuntimeException("尝试通过反射破解单例");
        }*/
    }

    private static class Singleton {
        private static final Singleton003 INSTANCE = new Singleton003();
    }

    public static Singleton003 getInstance() {
        return Singleton.INSTANCE;
    }

    // 针对 2.序列化/反序列化破解单例 的解决方案
    // 若存在该readResolve() 方法，则反序列化时直接返回INSTANCE，不会新建对象
    /*private Object readResolve() throws ObjectStreamException{
        return Singleton.INSTANCE;
    }*/

}

// 1. 测试 单例类实现
/*class Test01 {
    public static void main(String[] args) {
        // 'Singleton003()' has private access in 'ash.singleton.Singleton003'
        // Singleton003 instance = new Singleton003();
        Singleton003 instance01 = Singleton003.getInstance();
        Singleton003 instance02 = Singleton003.getInstance();
        System.out.println(instance01==instance02); // true
    }
}*/

// 2. 测试 是否能够通过反射破解单例
/*class Test02 {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("ash.singleton.Singleton003");
        Constructor constructor = clazz.getDeclaredConstructor(null);

        constructor.setAccessible(true);

        Singleton003 instance01 = Singleton003.getInstance();
        Singleton003 instance02 = Singleton003.getInstance();
        Singleton003 instance03 = (Singleton003) constructor.newInstance();
        Singleton003 instance04 = (Singleton003) constructor.newInstance();

        System.out.println(instance01 == instance02); // true
        System.out.println(instance02 == instance03); // false
        System.out.println(instance03 == instance04); // false
    }
}*/

// 3. 测试 是否能够通过序列化/反序列化破解单例
/*
class Test03 {
    public static void main(String[] args) throws Exception {
        Singleton003 instance001 = Singleton003.getInstance();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("Singleton.txt")
        );
        objectOutputStream.writeObject(instance001);
        objectOutputStream.flush();
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("Singleton.txt")
        );
        Singleton003 instance002 = (Singleton003) objectInputStream.readObject();

        System.out.println(instance001); // ash.singleton.Singleton003@1c53fd30
        System.out.println(instance002); // ash.singleton.Singleton003@246ae04d
        System.out.println(instance001 == instance002); // false
    }
}*/
