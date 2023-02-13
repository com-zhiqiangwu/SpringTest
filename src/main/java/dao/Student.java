package dao;

public class Student {

    private String name;
    private String age;
    private String email;
    private School school;

    public Student() {
        System.out.println("spring调用了Student无参构造方法");
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String age, String email, School school) {
        System.out.println("Spring调用了Student有参构造方法");
        this.name = name;
        this.age = age;
        this.email = email;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String toString(){
       return  "Student[name="+name+",age="+age+",email="+email+",school="+school+"]";
    }
}
