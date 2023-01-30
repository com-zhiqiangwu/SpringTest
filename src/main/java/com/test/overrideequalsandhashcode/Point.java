package com.test.overrideequalsandhashcode;

import java.util.HashMap;
import java.util.Objects;

public class Point {
    private final int x,y;

    public Point(int x,int y){
       this.x=x;
       this.y=y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point)) return false;
        Point point = (Point) obj;
        return point.x==x && point.y == y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    /**
     *
     * 当只重写equals方法，不重写hashCode时，违反规定：equals相等的对象必须具有相等的哈希码（因为hashCode的返回值还是按照Object类的规范：同一对象的hashCode值相同）。
     *
     * 如果不这样做，你的类违反了hashCode的通用约定，对于HashSet, HashMap, HashTable等基于hash值的类就会出现问题。
     *
     * 以HashMap为例，当集合要添加新的对象时，先调用这个对象的hashCode方法，得到对应的hashcode值，实际上在HashMap的具体实现中会用一个table保存已经存进去的对象的hashcode值，如果table中没有该hashcode值，它就可以直接存进去，不用再进行任何比较了;如果存在该hashcode值，就调用它的equals方法与新元素进行比较，相同的话就不存了，不相同就散列其它的地址。
     * 这样解决了向含有大量数据的集合中添加元素时，大量频繁的操作equals方法的问题
     * @param args
     */

    //验证为什么重写equals一定要重写hashcode
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        System.out.println(p1.equals(p2));

        HashMap<Point, String> map = new HashMap<>();
        map.put(p1,"p1");
        //Point类并没有重写hashCode方法，导致两个相等的实例p1和p2返回了不同的哈希码，违反了hashCode的约定，
        // put方法把实例p1放到了一个哈希桶(hash bucket)中，但因为p2的哈希码不等于p1的哈希码，
        // 所以get方法会从其它哈希桶中去查找。所以返回null
        //重写就会返回P1
        System.out.println(map.get(p2));



    }
}
