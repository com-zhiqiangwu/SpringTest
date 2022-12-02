package dao;

import org.springframework.stereotype.Component;

@Component("Teacher")
public class Teacher {

    private String name;
    private String sex;


    public Teacher() {
        System.out.println("spring调用了Teacher无参构造方法");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String toString(){
        return "School[name="+name+",sex="+sex+"]";
    }
}
