package service.impl;

import service.SomeService;

public class ISomeServiceImpl implements SomeService {

    public ISomeServiceImpl() {
        System.out.println("ISomeServiceImpl的构造方法");
    }

    @Override
    public void doSome() {
        System.out.println("执行了ISomeServiceImpl的doSome()方法");
    }
}
