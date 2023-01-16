package com.test.datastructure;

public class LoopQueen {
    private int[] queenArr;//用来实现循环队列的数组
    private int front;//队首(数组下标)
    private int rear;//队尾（数组下标）

    public LoopQueen(int capacity){
        this.queenArr = new int[capacity];
        System.out.println("循环队列初始化成功，最大容量为:"+(capacity-1));
    }

    /**
     * 入队
     * @param element  入队元素
     * */
    public void enqueen(int element){
        //如果队尾下标和队首下标相同，说明队列已满
        if ((rear+1)%queenArr.length == front){
            System.out.println("队列已满！");
        }
        //新元素放队尾
        queenArr[rear] = element;
        //之前队尾已有数据，队尾下标后移一位
        rear = (rear+1)%queenArr.length;
    }

    /**
     * 出队
     */
    public int dequeen(){
        //如果队尾等于队首，说明队列为空
        if (rear == front){
            System.out.println("队列已空");
        }
        //取出要删除队首元素
        int deQueenElement = queenArr[front];
        //将原队首下标后一位设置为新队首
        front = (front+1)%queenArr.length;
        return deQueenElement;
    }

    /**
     * 打印队列
     */
    public void outPut(){
        for (int i = front; i !=rear; i=(i+1)%queenArr.length) {

               if (i!=rear && i!=(rear-1)){
                   System.out.print(queenArr[i]+"-->");
               }else{
                   System.out.println(queenArr[i]);
               }


        }
    }
}
