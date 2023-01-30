package test.enumtest;

import com.test.enumtest.Season;
import org.junit.Test;

public class EnumTest {

    @Test
    public void test1(){
        Season spring = Season.SPRING;
        System.out.println(Season.SPRING);
        System.out.println("******************************");
        for (Season s: Season.values()) {
            System.out.println(s);//返回枚举类所有的常量对象
            System.out.println(s.name());//返回当前对象名（常量名）子类不能重写
            System.out.println(s.ordinal());//返回当前对象的位置号，默认从零开始
        }
        Season spring1 = Season.valueOf("SPRING");//将字符串转换成已有的枚举对象，要求字符串必须为已有的常量名，否则报异常
        System.out.println(spring == spring1);

        System.out.println(Season.SPRING.compareTo(Season.SUMMER));//比较两个枚举常量的大小(编号),返回的结果是两个枚举常量的编号相减得到的数
        System.out.println(Season.SUMMER.compareTo(Season.SPRING));
    }
}
