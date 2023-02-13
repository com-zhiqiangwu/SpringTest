package com.test.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import service.SomeService;
import service.impl.ISomeServiceImpl;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {


    //Cglib代理可以称为子类代理，是在内存中构建一个子类对象，从而实现对目标对象功能的扩展。
    //C代理商不仅想代理公司，而且还想代理多个工厂的产品。
    //Cglib通过Enhancer 来生成代理类，通过实现MethodInterceptor接口，
    // 并实现其中的intercept方法，在此方法中可以添加增强方法，并可以利用反射Method或者MethodProxy继承类 来调用原方法。
    public Object getCGlibProxy(Class c){
        //工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(c);
        //设置回调函数
        enhancer.setCallback(new MyMethodInterceptor());
        //创建子类（代理对象）
        return enhancer.create();
    }

    /**
     *
     * @param o     代理对象
     * @param method  被代理对象的方法
     * @param objects  方法入参
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib:调用方法之前的处理");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib:调用方法之后的处理");
        return result;
    }

    public static void main(String[] args) {
        SomeService cGlibProxy = (SomeService) new MyMethodInterceptor().getCGlibProxy(ISomeServiceImpl.class);
        cGlibProxy.doSome();
    }
}
