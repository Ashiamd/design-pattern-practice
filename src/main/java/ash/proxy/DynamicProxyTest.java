package ash.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理模式-动态代理
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/13 3:47 PM
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        Worker proxyWorker = (Worker) Proxy
                .newProxyInstance(ClassLoader.getSystemClassLoader(),
                        new Class[]{Worker.class},
                        new ProxyInvocationHandler(new Employee()));
        proxyWorker.work();
    }
}

interface Worker{
    void work();
}

class Employee implements Worker{
    @Override
    public void work() {
        System.out.println("just work ~");
    }
}

class ProxyInvocationHandler implements InvocationHandler{
    Worker worker;
    public ProxyInvocationHandler(Worker worker) { this.worker = worker; }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do something before work ~");
        method.invoke(worker, args);
        System.out.println("do something after work ~");
        return null;
    }
}