package com.test.datastructure;

public class Node {

    public int data;//数据
    public Node next;//下个节点指针

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }


}
