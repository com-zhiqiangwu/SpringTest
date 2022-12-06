package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

@Aspect
public class MyAspect {

    @Before(value = "execution(public void service.impl.ISomeServiceImpl.doSome())")
    public void myBefore(JoinPoint joinPoint){
        System.out.println("签名:"+joinPoint.getSignature());
        System.out.println("名称:"+joinPoint.getSignature().getName());
        //就是你切面要执行的功能代码
        System.out.println("前置通知，切面功能：在目标方法之前输出执行时间："+new Date());
    }
}
