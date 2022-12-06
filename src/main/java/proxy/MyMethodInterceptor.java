package proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {

    private Object target;

    public MyMethodInterceptor(Object target) {
        this.target = target;
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
}
