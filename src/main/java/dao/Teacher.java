package dao;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("Teacher")
public class Teacher{

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

    public void  changeNumToChinese(String num){
        String[] str1 = { "零", "一", "二", "三", "四", "五", "六","七", "八", "九" };
        String[] str2 = { "十", "百", "千", "万", "十", "百", "千", "亿" };
        String res = "";
        //6000200
// 遍历一行中所有数字
        for (int k = -1; num.length() > 0; k++) {
// substring()截取函数，解析最后一位
            int j = Integer.parseInt(num.substring(num.length() - 1, num.length()));
            String rtemp = str1[j];
// 数值不是0且不是个位 或者是万位或者是亿位 则去取单位
            if (j != 0 && k != -1 || k % 8 == 3 || k % 8 == 7) {
                rtemp += str2[k % 8];
            }
// 拼在之前的前面
            res = rtemp + res;
// substring()截取函数，去除最后一位
            num = num.substring(0, num.length() - 1);
        }
// 去除后面连续的零零..x`
        while (res.endsWith(str1[0])) {
            res = res.substring(0, res.lastIndexOf(str1[0]));
        }
// replaceAll()替换函数，将零零替换成零
        while (res.indexOf(str1[0] + str1[0]) != -1) {
            res = res.replaceAll(str1[0] + str1[0], str1[0]);
        }
// replaceAll()替换函数，将 零+某个单位 这样的窜替换成 该单位 去掉单位前面的零
        for (int m = 1; m < str2.length; m++) {
            res = res.replaceAll(str1[0] + str2[m], str2[m]);
        }
        System.out.println(res);

    }

    public String toString(){
        return "School[name="+name+",sex="+sex+"]";
    }
}
