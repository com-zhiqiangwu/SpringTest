package com.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxy  implements InvocationHandler {
    private Object targetObj;

    public JdkProxy(Object targetObj) {
        this.targetObj = targetObj;
    }

    /**
     *
     * @param proxy  被代理对象
     * @param method  目标对象中的方法对象
     * @param args   方法对象的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk:执行方法之前的处理");
        Object invoke = method.invoke(targetObj, args);
        System.out.println("jdk:执行方法之后的处理");
        return invoke;
    }
}
