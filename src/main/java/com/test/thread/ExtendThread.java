package com.test.thread;

/**
 * 1、创建步骤：
 *         > 创建一个继承于 Thread类的子类
 *
 *         > 重写Thread类的 run()方法->此线程执行的操作声明在 run()中，如遍历100以内所有的偶数
 *
 *         > 创建此子类对象
 *
 *         > 调用 start()方法：有两个作用：①启动当前线程 ②调用当前线程的 run()
 */
public class ExtendThread extends Thread{
    private final String threadName;//线程名称

    public ExtendThread(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i%2==0){
                System.out.println(threadName+"******"+i);
            }
        }
    }

    public static void main(String[] args) {
        ExtendThread ta = new ExtendThread("线程A");
        ExtendThread tb = new ExtendThread("线程B");

        //ta 调用join方法会让其他线程处于等待状态，和设置线程优先级一样的效果
        try {
            ta.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ta.start();
        tb.start();
    }
}
