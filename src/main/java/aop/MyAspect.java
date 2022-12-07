package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

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



    @AfterReturning(value = "execution(* *..ISomeServiceImpl.doAfter(..))",returning = "res")
    public void myAfterReturning(JoinPoint joinPoint,Object res){
        System.out.println("后置通知：方法的定义"+joinPoint.getSignature());
        System.out.println("后置通知:方法的名字"+joinPoint.getSignature().getName());
        System.out.println("后置通知:获取方法的返回值"+res);
        if ("a".equals(res)){
            System.out.println("########"+res);
        }else {
            System.out.println("########"+res);
        }
    }

    @After(value = "execution(public void service.impl.ISomeServiceImpl.doSome())")
    public void myAfter(JoinPoint joinPoint){
        System.out.println("签名:"+joinPoint.getSignature());
        System.out.println("名称:"+joinPoint.getSignature().getName());
        //就是你切面要执行的功能代码
        System.out.println("后置通知通知，切面功能：在目标方法之后输出执行时间："+new Date());
    }


    @Around(value = "execution(* *..ISomeServiceImpl.doSome())")
    public void myAround(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("环绕通知：切面功能：执行方法之前输出当前时间"+new Date());
        pjp.proceed();
        System.out.println("环绕通知：切面功能：执行方法之后输出当前时间"+new Date());
    }
}
