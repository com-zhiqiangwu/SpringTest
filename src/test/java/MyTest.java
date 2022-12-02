import dao.Student;
import dao.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import proxy.ISomeServiceStaticProxyImpl;
import proxy.JdkProxy;
import service.SomeService;
import service.impl.ISomeServiceImpl;

import java.lang.reflect.Proxy;

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
}
