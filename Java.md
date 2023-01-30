一、final
1.final关键字可以用来修饰类、方法、变量。各有不同。

A、修饰类(class)。
     1、该类不能被继承。
     2、类中的方法不会被覆盖（重写），因此默认都是final的。
     3、用途：设计类时，如果该类不需要有子类，不必要被扩展，类的实现细节不允许被改变，那么就设计成final类

B、修饰方法(method)
     1、该方法可以被继承，但是不能被覆盖。
     2、用途：一个类不允许子类覆盖该方法，则用final来修饰
     3、好处：可以防止继承它的子类修改该方法的意义和实现；更为高效，编译器在遇到调用fianal方法转入内嵌机制，提高了执行效率。
     4、注意：父类中的private成员方法不能被子类覆盖，因此，private方法默认是final型的(可以查看编译后的class文件)

C、修饰变量(variable)
     1、用final修饰后变为常量。包括静态变量、实例变量和局部变量这三种。
     2、特点：可以先声明，不给初值，这种叫做final空白。但是使用前必须被初始化。一旦被赋值，将不能再被改变。

D、修饰参数(arguments)
     1、用final修饰参数时，可以读取该参数，但是不能对其作出修改

2、final关键字不能用来抽象类和接口。

二、finalize
Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。
这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象调用的，但是什么时候调用 finalize 没有保证。

finalize的执行过程(生命周期)

(1) 首先，大致描述一下finalize流程：当对象变成(GC Roots)不可达时，GC会判断该对象是否覆盖了finalize方法，若未覆盖，则直接将其回收。否则，若对象未执行过finalize方法，将其放入F-Queue队列，由一低优先级线程执行该队列中对象的finalize方法。执行finalize方法完毕后，GC会再次判断该对象是否可达，若不可达，则进行回收，否则，对象“复活”。

(2) 具体的finalize流程：

对象可由两种状态，涉及到两类状态空间，一是终结状态空间 F = {unfinalized, finalizable, finalized}；二是可达状态空间 R = {reachable, finalizer-reachable, unreachable}。各状态含义如下：

unfinalized: 新建对象会先进入此状态，GC并未准备执行其finalize方法，因为该对象是可达的

finalizable: 表示GC可对该对象执行finalize方法，GC已检测到该对象不可达。正如前面所述，GC通过F-Queue队列和一专用线程完成finalize的执行

finalized: 表示GC已经对该对象执行过finalize方法

reachable: 表示GC Roots引用可达

finalizer-reachable(f-reachable)：表示不是reachable，但可通过某个finalizable对象可达

unreachable：对象不可通过上面两种途径可达
![img.png](img.png)

(1)新建对象首先处于[reachable, unfinalized]状态(A)

(2)随着程序的运行，一些引用关系会消失，导致状态变迁，从reachable状态变迁到f-reachable(B, C, D)或unreachable(E, F)状态

(3)若JVM检测到处于unfinalized状态的对象变成f-reachable或unreachable，JVM会将其标记为finalizable状态(G,H)。若对象原处于[unreachable, unfinalized]状态，则同时将其标记为f-reachable(H)。

(4)在某个时刻，JVM取出某个finalizable对象，将其标记为finalized并在某个线程中执行其finalize方法。由于是在活动线程中引用了该对象，该对象将变迁到(reachable, finalized)状态(K或J)。该动作将影响某些其他对象从f-reachable状态重新回到reachable状态(L, M, N)

(5)处于finalizable状态的对象不能同时是unreahable的，由第4点可知，将对象finalizable对象标记为finalized时会由某个线程执行该对象的finalize方法，致使其变成reachable。这也是图中只有八个状态点的原因

(6)程序员手动调用finalize方法并不会影响到上述内部标记的变化，因此JVM只会至多调用finalize一次，即使该对象“复活”也是如此。程序员手动调用多少次不影响JVM的行为

(7)若JVM检测到finalized状态的对象变成unreachable，回收其内存(I)

(8)若对象并未覆盖finalize方法，JVM会进行优化，直接回收对象（O）

(9)注：System.runFinalizersOnExit()等方法可以使对象即使处于reachable状态，JVM仍对其执行finalize方法

