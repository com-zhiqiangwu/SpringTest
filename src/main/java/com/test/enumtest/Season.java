package com.test.enumtest;

public enum Season {

    SPRING("春天","温暖"),SUMMER("夏天","炎热"),AUTUMN("秋天","凉爽"),WINTER("冬天","寒冷");

    private String name;
    private String desc;

    private Season(String name,String desc){

        this.name =  name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
