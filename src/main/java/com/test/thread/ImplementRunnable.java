package com.test.thread;

/**
 * 1、创建步骤：
 *         > 创建一个实现了 Runnable接口的类
 *
 *         > 实现类去实现 Runnable接口中的抽象方法：run()
 *
 *         > 创建实现类的对象
 *
 *         > 将此实现类作为参数传递到 Thread类的构造器中，创建 Thread类的对象
 *
 *         > 通过 Thread类的对象调用 start()
 */
public class ImplementRunnable  implements Runnable{
    private final String threadName;
    public ImplementRunnable(String threadName){
        this.threadName=threadName;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i%2 == 0) System.out.println(threadName+"******"+i);
        }
    }

    public static void main(String[] args) {
        ImplementRunnable ta = new ImplementRunnable("线程A");
        ImplementRunnable tb = new ImplementRunnable("线程B");

        Thread threadA = new Thread(ta);
        Thread threadB = new Thread(tb);

        //设置优先级
        threadA.setPriority(2);
        threadB.setPriority(1);

        threadA.start();
        threadB.start();
    }
}
