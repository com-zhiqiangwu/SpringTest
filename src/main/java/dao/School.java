package dao;

public class School {

    private String name;
    private String address;

    public School() {
        System.out.println("spring调用了School无参构造方法");
    }

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){
        return  "School[name="+name+",address="+address+"]";
    }
}
