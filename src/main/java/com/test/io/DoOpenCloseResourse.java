package com.test.io;

public class DoOpenCloseResourse implements  AutoCloseable{
    private String name;

    public DoOpenCloseResourse(String name) {
        this.name = name;
    }

    @Override
    public void close() throws Exception {
        System.out.println(name+"资源关闭");
    }
    public void open(){
        System.out.println(name+"资源打开");
    }

}
