package com.test.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestCallableUseCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<>();

        //创建5个任务并执行
        for (int i = 0; i < 5; i++) {
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> submit = executorService.submit(new TestCallable(i));
            //将任务处理结果存到list
            resultList.add(submit);
        }
        //遍历执行结果

        for (Future future: resultList) {
            try {
                //Future返回如果没有完成，则一直循环等待，直到Future返回完成
                while (!future.isDone()){
                    //打印各个线程（任务）执行的结果
                    System.out.println(future.get());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }

        }
    }
}
class TestCallable implements Callable{

    private int id;

    public TestCallable(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("call()方法被自动调用"+Thread.currentThread().getName());
        return "call()方法被自动调用，任务的返回结果是："+id+"---"+Thread.currentThread().getName();
    }
}
