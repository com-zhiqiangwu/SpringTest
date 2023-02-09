import dao.Student;
import dao.Teacher;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import proxy.JdkProxy;
import proxy.MyMethodInterceptor;
import service.SomeService;
import service.impl.ISomeServiceImpl;

import java.lang.reflect.Proxy;
import java.util.*;

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

    }

    @Test
    public void test5(){
        /*jdk动态代理*/
        // 代理对象不需要实现接口，但是目标对象一定要实现接口，否则不能用动态代理。
        // 动态代理的方式中，所有的函数调用最终都会经过 invoke 函数的转发，因此我们就可以在这里做一些自己想做的操作，比如日志系统、事务、拦截器、权限控制等
        // JDK 动态代理有一个最致命的问题是它只能代理实现了某个接口的实现类，并且代理类也只能代理接口中实现的方法，要是实现类中有自己私有的方法，而接口中没有的话，该方法不能进行代理调用。

        //注意该方法(newProxyInstance)是在Proxy类中是静态方法，且接收的三个参数依次为：
        //ClassLoader loader：指定当前目标对象使用类加载器，获取加载器的方法是固定的。
        // Class<?>[] interfaces：目标对象实现的接口的类型，使用泛型方式确认类型。
        // InvocationHandler h：事件处理，执行目标对象的方法时，会触发事件处理器的方法，会把当前执行目标对象的方法作为参数传入。

        ISomeServiceImpl iSomeService = new ISomeServiceImpl();
        JdkProxy jdkProxy = new JdkProxy(iSomeService);
        Object o = Proxy.newProxyInstance(iSomeService.getClass().getClassLoader(), iSomeService.getClass().getInterfaces(), jdkProxy);

        SomeService o1 = (SomeService) o;
        o1.doSome();

     }

     @Test
    public void test6(){

        //Cglib代理可以称为子类代理，是在内存中构建一个子类对象，从而实现对目标对象功能的扩展。
        //C代理商不仅想代理公司，而且还想代理多个工厂的产品。
        //Cglib通过Enhancer 来生成代理类，通过实现MethodInterceptor接口，
         // 并实现其中的intercept方法，在此方法中可以添加增强方法，并可以利用反射Method或者MethodProxy继承类 来调用原方法。

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


    @Test
    public void test13(){
        TreeMap<String,Student> treeMap = new TreeMap() {{
            put("1",new Student("张三"));
            put("2",new Student("李四"));
            put("3",new Student("王五"));
            put("4",new Student("赵六"));
        }};

        for (Map.Entry<String,Student> entry:treeMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println("*************************hashmap*********************");
        HashMap<String,Student> hashMap = new HashMap() {{
            put("1", new Student("张三"));
            put("2", new Student("李四"));
            put("3", new Student("王五"));
            put("4", new Student("赵六"));
        }};

        for (Map.Entry<String,Student> entry:hashMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }

    @Test
    public void test18(){
        try {
//            System.exit(1);
            System.out.println(2/0);
        } catch (Exception e) {
            System.out.println("catch");
            e.printStackTrace();
            Runtime.getRuntime().halt(0);
        } finally {
            System.out.println("finally");
        }
    }

}
