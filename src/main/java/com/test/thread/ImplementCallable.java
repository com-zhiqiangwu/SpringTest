package com.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 1、创建步骤：
 *         > 创建一个实现 Callable接口的实现类
 *
 *         > 实现 call()方法，将此线程需要执行的操作声明在 call()中
 *
 *         > 创建 Callable接口实现类的对象
 *
 *         > 将此 Callable接口实现类的对象作为参数传递到 FutureTask构造器中，创建 FutureTask对象
 *
 *         > 将 FutureTask的对象作为参数传递到 Thread类的构造器中，创建 Thread对象，并调用 start()
 *
 *         > 如果对返回值感兴趣，则通过 FutureTask对象的 get()方法获取 Callable中 call()的返回值
 */
public class ImplementCallable implements Callable {

    private final String threadName;

    public ImplementCallable(String threadName){
        this.threadName = threadName;
    }
    @Override
    public Integer call() throws Exception {
        int j =0;
        for (int i = 0; i < 10; i++) {
            if (i%2 == 0){
                j=i; System.out.println(threadName+"*********"+i);
            }

        }
        return j;
    }

    public static void main(String[] args) {
        FutureTask<Integer> fa = new FutureTask<>(new ImplementCallable("线程A"));
        FutureTask<Integer> fb = new FutureTask<>(new ImplementCallable("线程B"));

        Thread threadA = new Thread(fa);
        Thread threadB = new Thread(fb);

        threadA.start();
        threadB.start();
        ;

        // 获取线程执行结果。如果此时获取结果的任务还未执行完成，会让出CPU，直至任务执行完成才获取结果
        try {
            Integer integer = fa.get();
            Integer integer1 = fb.get();
            System.out.println(integer);
            System.out.println(integer1);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();

        }
    }
}
