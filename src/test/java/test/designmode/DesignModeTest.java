package test.designmode;

import com.test.designmode.easyfactorymode.Pizza;
import com.test.designmode.easyfactorymode.PizzaFactory;
import com.test.designmode.easyfactorymode.PizzaStore;
import com.test.designmode.iteratormode.Book;
import com.test.designmode.iteratormode.BookShelf;
import com.test.designmode.iteratormode.Iterator;
import com.test.designmode.singletonmode.SingletonModeDoubleCheckLockLazyMan;
import com.test.designmode.singletonmode.SingletonModeHungryMan;
import com.test.designmode.singletonmode.SingletonModeLazyMan;
import com.test.designmode.singletonmode.SingletonModeSynchronizedLazyMan;
import org.junit.Test;

public class DesignModeTest {


    //单例模式：懒汉
    @Test
    public void test1(){
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    SingletonModeLazyMan instance = SingletonModeLazyMan.getInstance();
                    System.out.println(instance);
                }
            }, "线程"+i);
            thread.start();
        }
    }

    //单例模式：懒汉-方法加锁synchronized
    @Test
    public void test2(){
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    SingletonModeSynchronizedLazyMan instance = SingletonModeSynchronizedLazyMan.getInstance();
                    System.out.println(instance);
                }
            }, "线程"+i);
            thread.start();
        }
    }

    //单例模式：懒汉-双重检查锁
    @Test
    public void test3(){
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    SingletonModeDoubleCheckLockLazyMan instance = SingletonModeDoubleCheckLockLazyMan.getInstance();
                    System.out.println(instance);
                }
            }, "线程"+i);
            thread.start();
        }
    }

    //单例模式：饿汉
    @Test
    public void test4(){
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    SingletonModeHungryMan instance = SingletonModeHungryMan.getInstance();
                    System.out.println(instance);
                }
            }, "线程"+i);
            thread.start();
        }
    }

    //简单工厂模式-静态工厂模式
    @Test
    public void test5(){

        PizzaStore pizzaStore = new PizzaStore(new PizzaFactory());
        //制作芝士披萨
        Pizza pizza = pizzaStore.makePizza("chesses");

        //制作哈利披萨
        Pizza pizza1 = pizzaStore.makePizza("clam");
    }

    //迭代模式
    @Test
    public void test6(){
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook("A");
        bookShelf.appendBook("B");
        bookShelf.appendBook("C");
        bookShelf.appendBook("D");
        bookShelf.appendBook("E");
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()){
            Book next = (Book) iterator.next();
            System.out.println(next.getName());
        }
    }
}
