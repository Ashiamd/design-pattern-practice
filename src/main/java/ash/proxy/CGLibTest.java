package ash.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理模式-CGLib
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/13 4:00 PM
 */
public class CGLibTest {
    public static void main(String[] args) {
        Dog dog = (Dog) CGLibProxy.getProxy(new Dog());
        dog.run();
    }
}

class Dog{
    public void run(){ System.out.println(" dog run "); }
}

class CGLibProxy implements MethodInterceptor{
    Object target;
    public CGLibProxy(Object target) { this.target = target; }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("do something before " + method.getName());
        Object result = method.invoke(target, objects);
        System.out.println("do something after " + method.getName());
        return result;
    }

    public static Object getProxy(Object target){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new CGLibProxy(target));
        return enhancer.create();
    }
}