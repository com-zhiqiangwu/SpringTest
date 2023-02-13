package com.test.proxy;

import service.SomeService;
import service.impl.ISomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy {

    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(new ISomeServiceImpl().getClass().getClassLoader(), new ISomeServiceImpl().getClass().getInterfaces(),
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("日志方法执行了");
                Object invoke = method.invoke(new ISomeServiceImpl(), args);
                System.out.println("事务方法执行了");
                return invoke;
            }
        });
    }
    public static void main(String[] args) {
        /*jdk动态代理*/
        // 代理对象不需要实现接口，但是目标对象一定要实现接口，否则不能用动态代理。
        // 动态代理的方式中，所有的函数调用最终都会经过 invoke 函数的转发，因此我们就可以在这里做一些自己想做的操作，比如日志系统、事务、拦截器、权限控制等
        // JDK 动态代理有一个最致命的问题是它只能代理实现了某个接口的实现类，并且代理类也只能代理接口中实现的方法，要是实现类中有自己私有的方法，而接口中没有的话，该方法不能进行代理调用。

        //注意该方法(newProxyInstance)是在Proxy类中是静态方法，且接收的三个参数依次为：
        //ClassLoader loader：指定当前目标对象使用类加载器，获取加载器的方法是固定的。
        // Class<?>[] interfaces：目标对象实现的接口的类型，使用泛型方式确认类型。
        // InvocationHandler h：事件处理，执行目标对象的方法时，会触发事件处理器的方法，会把当前执行目标对象的方法作为参数传入。

        ISomeServiceImpl iSomeService = new ISomeServiceImpl();
        SomeService proxy = (SomeService) new JdkProxy(iSomeService).getProxy();
        proxy.doSome();
    }
}
