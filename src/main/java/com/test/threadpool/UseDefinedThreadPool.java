package com.test.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UseDefinedThreadPool {

    public static void main(String[] args) {
        //创建等待队列
        BlockingQueue<Runnable> runnables = new ArrayBlockingQueue<>(20);

        //创建线程池，池中保存线程数为3，允许的最大线程数为5
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 5, 50, TimeUnit.MICROSECONDS, runnables);

        //创建七个任务
        Runnable th1 = new MyThread();
        Runnable th2 = new MyThread();
        Runnable th3 = new MyThread();
        Runnable th4 = new MyThread();
        Runnable th5 = new MyThread();
        Runnable th6 = new MyThread();
        Runnable th7 = new MyThread();

        //将每个任务放入线程池
        threadPoolExecutor.execute(th1);
        threadPoolExecutor.execute(th2);
        threadPoolExecutor.execute(th3);
        threadPoolExecutor.execute(th4);
        threadPoolExecutor.execute(th5);
        threadPoolExecutor.execute(th6);
        threadPoolExecutor.execute(th7);

        //关闭线程池
         threadPoolExecutor.shutdown();
    }

}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在执行。。。。。。");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
