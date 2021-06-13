package ash.flyweight;

import java.util.ArrayList;

/**
 * 享元模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/13 1:47 PM
 */
public class FlyweightTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadFactory threadFactory = new ThreadFactory(5);
        for (int i = 0; i < 20; ++i) {
            threadFactory.doSomething("someting_" + i);
        }
        threadFactory.killAll();
    }
}

class ThreadFactory {
    ArrayList<MyThread> threadList;

    public ThreadFactory(int count) {
        threadList = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            MyThread thread = new MyThread();
            threadList.add(thread);
            new Thread(thread).start();
            System.out.println("new Thread " + i);
        }
    }

    public void doSomething(String something) {
        for (MyThread thread : threadList) {
            if (!thread.isBusy()) {
                thread.setSomething(something);
                return;
            }
        }
        System.out.println("too busy !! can't do : " + something);
    }

    public void killAll(){
        for(MyThread thread:threadList){
            thread.setDead();
        }
    }
}

class MyThread implements Runnable {
    private String something;
    private boolean busy;
    private boolean dead;

    public void setSomething(String something) { this.something = something; }
    public boolean isBusy() { return busy; }
    public void setDead(){ this.dead = true; }

    @Override
    public void run() {
        while (!dead) {
            if (!busy && something != null) {
                busy = true;
                System.out.println("do something : " + something);
                something = null;
                busy = false;
            }
        }
    }
}