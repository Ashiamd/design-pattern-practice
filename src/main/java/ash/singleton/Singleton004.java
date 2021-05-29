package ash.singleton;

/**
 * 枚举
 * 优点：
 *  1. 线程安全
 *  2. 本身防止反射破解单例实现
 *  3. 本身防止序列化破解单例实现
 * 缺点：
 *  1. 使用场景少
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/5/29 3:52 PM
 */
public enum Singleton004 {
    INSTANCE("HELLO","WORLD",1),
    INSTANCE2("HELLO","WORLD",1);

    private final String var1;
    private final String var2;
    private final Integer var3;

    Singleton004(String var1,String var2,Integer var3){
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }

    public String getVar1() {
        return var1;
    }

    public String getVar2() {
        return var2;
    }

    public Integer getVar3() {
        return var3;
    }
}

// 1. 测试 单例类实现
/*class Test01 {
    public static void main(String[] args) {
        // 'Singleton004(java.lang.String, java.lang.String, java.lang.Integer)' has private access in 'ash.singleton.Singleton004'
        // Singleton004 instance = new Singleton004();
        Singleton004 instance01 = Singleton004.INSTANCE;
        Singleton004 instance02 = Singleton004.INSTANCE;
        System.out.println(instance01.getVar1()); // HELLO
        System.out.println(instance02.getVar2()); // WORLD
        System.out.println(instance01.getVar3()); // 1
        System.out.println(instance01==instance02); // true
    }
}*/

// 2. 测试 是否能够通过反射破解单例
/**
 * Exception in thread "main" java.lang.NoSuchMethodException: ash.singleton.Singleton004.<init>()
 * 	at java.lang.Class.getConstructor0(Class.java:3082)
 * 	at java.lang.Class.getDeclaredConstructor(Class.java:2178)
 * 	at ash.singleton.Test02.main(Singleton004.java:39)
 */
/*class Test02 {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("ash.singleton.Singleton004");
        Constructor constructor = clazz.getDeclaredConstructor();

        constructor.setAccessible(true);

        Singleton004 instance01 = Singleton004.INSTANCE;
        Singleton004 instance02 = Singleton004.INSTANCE;
        Singleton004 instance03 = (Singleton004) constructor.newInstance();
        Singleton004 instance04 = (Singleton004) constructor.newInstance();

        System.out.println(instance01 == instance02); // true
        System.out.println(instance02 == instance03); // false
        System.out.println(instance03 == instance04); // false
    }
}*/

// 3. 测试 是否能够通过序列化/反序列化破解单例
/*class Test03 {
    public static void main(String[] args) throws Exception {
        Singleton004 instance001 = Singleton004.INSTANCE;

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("Singleton.txt")
        );
        objectOutputStream.writeObject(instance001);
        objectOutputStream.flush();
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("Singleton.txt")
        );
        Singleton004 instance002 = (Singleton004) objectInputStream.readObject();

        System.out.println(instance001); // INSTANCE
        System.out.println(instance002); // INSTANCE
        System.out.println(instance001 == instance002); // true
    }
}*/