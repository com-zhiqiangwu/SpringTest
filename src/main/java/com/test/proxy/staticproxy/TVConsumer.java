package com.test.proxy.staticproxy;

public class TVConsumer {
    //某公司生产电视机，在当地销售需要找到一个代理销售商。那么客户需要购买电视机的时候，就直接通过代理商购买就可以。
    //优点：静态代理模式在不改变目标对象的前提下，实现了对目标对象的功能扩展。
    //缺点：静态代理实现了目标对象的所有方法，一旦目标接口增加方法，代理对象和目标对象都要进行相应的修改，增加维护成本。
    public static void main(String[] args) {
        TVProxy tvProxy = new TVProxy();
        TV tv = tvProxy.productTV();
        System.out.println(tv);

    }
}
