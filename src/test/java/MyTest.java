import dao.Student;
import dao.Teacher;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import proxy.ISomeServiceStaticProxyImpl;
import proxy.JdkProxy;
import proxy.MyMethodInterceptor;
import service.SomeService;
import service.impl.ISomeServiceImpl;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyTest {
    private  static final String xml = "applicationContext.xml";
    private static final ApplicationContext ac = new ClassPathXmlApplicationContext(xml);

    public  ApplicationContext returnAC(){
        return ac;
    }

    @Test
    public void test1(){
        ISomeServiceImpl iSomeServiceImpl = (ISomeServiceImpl) MyTest.ac.getBean("ISomeServiceImpl");

        iSomeServiceImpl.doSome();
    }

    @Test
    public void test2(){

        Student student = (Student) MyTest.ac.getBean("Student");
        System.out.println(student.toString());

        Object date = MyTest.ac.getBean("date");
        System.out.println(date);
    }

    @Test
    public void test3() {
        String s = "applicationContextAnnotation.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(s);
        Teacher teacher = (Teacher) ac.getBean("Teacher");
        System.out.println(teacher);
    }

    @Test
    public void test4(){
        /*静态代理*/
        ISomeServiceStaticProxyImpl iSomeServiceProxy = new ISomeServiceStaticProxyImpl(new ISomeServiceImpl());
        iSomeServiceProxy.doSome();
    }

    @Test
    public void test5(){
        /*jdk动态代理*/
        ISomeServiceImpl iSomeService = new ISomeServiceImpl();
        JdkProxy jdkProxy = new JdkProxy(iSomeService);
        Object o = Proxy.newProxyInstance(iSomeService.getClass().getClassLoader(), iSomeService.getClass().getInterfaces(), jdkProxy);

        SomeService o1 = (SomeService) o;
        o1.doSome();
     }

     @Test
    public void test6(){
         ISomeServiceImpl iSomeService = new ISomeServiceImpl();
         Enhancer enhancer = new Enhancer();
         //设置enhancer对象的父类
         enhancer.setSuperclass(ISomeServiceImpl.class);
         //设置enhancer的回调对象
         enhancer.setCallback(new MyMethodInterceptor(iSomeService));
         //创建代理对象
         ISomeServiceImpl iSomeService1 = (ISomeServiceImpl) enhancer.create();
         //通过代理对象调用目标方法
         iSomeService1.doSome();
     }


     @Test
    public void test7(){

        /**AOP:前置通知*/
         ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
         //从容器中获取目标对象
         SomeService iSomeServiceImpl = (SomeService) ac.getBean("ISomeServiceImpl");
         //com.sun.proxy.$Proxy8:jdk动态代理
         System.out.println("proxy:"+iSomeServiceImpl.getClass().getName());
         //通过代理的对象执行方法，实现目标方法执行时，增强了的功能
         iSomeServiceImpl.doSome();
     }

     @Test
    public void test8(){
         /**
          * aop后置返回值通知
          */
         SomeService iSomeServiceImpl = (SomeService) ac.getBean("ISomeServiceImpl");
         System.out.println("proxy:"+iSomeServiceImpl.getClass().getName());
         iSomeServiceImpl.doAfter("a");
     }


    @Test
    public void test9(){
        /**
         * aop 最终通知
         */
        SomeService iSomeServiceImpl = (SomeService) ac.getBean("ISomeServiceImpl");
        System.out.println("proxy:"+iSomeServiceImpl.getClass().getName());
        iSomeServiceImpl.doSome();
    }

    @Test
    public void test10(){
        /**
         * aop环绕通知
         */
        SomeService iSomeServiceImpl = (SomeService) ac.getBean("ISomeServiceImpl");
        System.out.println("proxy:"+iSomeServiceImpl.getClass().getName());
        String around = iSomeServiceImpl.doAfter("around");
        System.out.println(around);
        System.out.println(3 % 8);
    }

    //数字转中文
    @Test
    public void test11(){
        Teacher teacher = new Teacher();
        teacher.changeNumToChinese("6000200");
    }

    @Test
    public void test12(){
        List list = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
            }
        };

    }

}
