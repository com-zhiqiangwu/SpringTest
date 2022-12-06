package service.impl;

import service.SomeService;

public class ISomeServiceImpl implements SomeService {

    public ISomeServiceImpl() {
        System.out.println("ISomeServiceImpl的构造方法");
    }

    @Override
    public void doSome() {
//给dosome方法增加一个功能，在dosome（）执行之前，输出方法的执行时间
        System.out.println("执行了ISomeServiceImpl的doSome()方法");
    }
}
