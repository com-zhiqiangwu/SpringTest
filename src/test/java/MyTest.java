import dao.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.ISomeServiceImpl;

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
}
