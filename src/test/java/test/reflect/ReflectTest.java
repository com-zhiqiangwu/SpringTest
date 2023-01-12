package test.reflect;

import com.sun.org.apache.bcel.internal.generic.LoadClass;
import com.test.reflect.Reflect;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

    //反射的使用
    @Test
    public void test1(){
        //获取类对象的几种方式
        try {
            //1.
            Class<?> aClass = Class.forName("com.test.reflect.Reflect");

            //2.
            Class<Reflect> reflectClass = Reflect.class;

            //3.
            Class<? extends Reflect> aClass1 = new Reflect().getClass();

            //4.
            Class<?> aClass2 = ClassLoader.getSystemClassLoader().loadClass("com.test.reflect.Reflect");
            System.out.println(aClass == reflectClass && reflectClass == aClass1 && aClass1 == aClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取构造方法，并通过构造方法来创建对象
    @Test
    public void test2(){

        try {
            Class<?> aClass = Class.forName("com.test.reflect.Reflect");
            //获取所有公共的构造方法
            Constructor<?>[] constructors = aClass.getConstructors();
            for (Constructor c : constructors){
                System.out.println(c);
            }
            System.out.println("######################################################");
            //获取所有构造方法，包含公共，私有，受保护
            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            for (Constructor c : declaredConstructors){
                System.out.println(c);
            }
            System.out.println("######################################################");
            //获取公共无参构造,来获取对象
            Constructor<?> constructor = aClass.getConstructor();
            Object o = constructor.newInstance();

            System.out.println("######################################################");
            //获取私有构造方法，来获取对象
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(boolean.class);
            declaredConstructor.setAccessible(true);
            Object o1 = declaredConstructor.newInstance(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取成员变量并使用
    @Test
    public void test3(){
        Reflect reflect = new Reflect("默认构造1");
        System.out.println(reflect.getConstructorName());
        try {
            Class<?> aClass = Class.forName("com.test.reflect.Reflect");
            Field setConstructorName = aClass.getField("constructorName");
            setConstructorName.set(reflect,"默认构造2");
            System.out.println(reflect.getConstructorName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取成员方法并使用
    @Test
    public void test4(){
        try {
            Class<?> aClass = Class.forName("com.test.reflect.Reflect");
            Reflect o = (Reflect)aClass.newInstance();
            Method setConstructorName = aClass.getMethod("setConstructorName", String.class);
            setConstructorName.invoke(o,"默认构造哈哈哈");
            System.out.println(o.getConstructorName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}