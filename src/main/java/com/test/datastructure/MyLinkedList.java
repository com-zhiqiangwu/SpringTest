package com.test.datastructure;

    public class MyLinkedList {

        class Node{
            public int data;//数据
            public Node next;//下个节点指针

            public Node(){

            }

            public Node(int data) {
                this.data = data;
            }

            public Node(int data, Node next){
                this.data = data;
                this.next = next;
            }

            public String toString(){
                return data+"";
            }
        }


        private int size;//链表元素个数
        private Node head;//头节点
        private Node last;//尾节点

        /**
         * 链表中添加元素
         * @param data  添加的数据
         * @param index  在哪个位置添加
         */
        public void insert(int data, int index){

            if (index<0 || index>size){
                System.out.println("超出链表节点范围！请重新输入入参");
            }
            Node insertNode = new Node(data);//根据要添加的数据初始化节点对象

            if (size == 0){
                //链表为空：当前节点即是头节点也是尾节点
                head=insertNode;
                last=insertNode;
            }else if (index == 0){
                //插入头部：1.插入元素的next指向原先的头节点.2.头节点为当前插入的节点
                insertNode.next = head;
                head = insertNode;
            }else if (index == size){
                //插入尾部：1.原尾部节点的next指向插入的节点.2.尾部节点变成当前插入节点
                last.next = insertNode;
                last=insertNode;
            }else {
                //中间插入：
                Node preNode = getNode(index);//根据要插入的位置获取此位置的前置节点
                insertNode.next  = preNode.next;//插入节点的next指向上一步查出节点的next
                preNode.next = insertNode;//插入位置的前置节点的next指向要插入的节点
            }
            size++;
        }

        /**
         * 删除链表元素
         * @param index
         * @return
         */
        public Node remove(int index){

            if (index < 0 || index >=size){
                System.out.println("超出链表范围！请重新输入");
            }
            Node removeNodeTemp = null;
            if (index==0){
                //删除头节点
               removeNodeTemp = head;//将要删除的头节点放入缓存
                head = head.next;//将原先头节点的next赋值给头节点
            }else if (index == size-1){
                //删除尾节点
                Node preNode = getNode(index);//获取尾节点的前置节点
                removeNodeTemp = preNode.next;//将要删除的尾节点缓存
                preNode.next = null;//将原先节点的前置节点的next置为空
                last = preNode;
            }else {
                //删除中间节点
                Node preNode = getNode(index);//根据插入位置获取前置节点
                Node nextNode = preNode.next.next;//将要删除的节点的next缓存
                removeNodeTemp = preNode.next;//将要删除的节点进行缓存
                preNode.next = nextNode;//将前置节点的next指向要删除的节点的next
            }
            size--;
            return removeNodeTemp;
        }

        /**
         * 根据位置获取前置节点
         * @param index
         * @return
         */
        public Node getNode(int index){
            if (index<0 || index>=size){
                System.out.println("该节点位置超出链表范围!请重新输入");
            }
            Node tempNode = head;//从头节点开始查找
            for (int i = 0; i < index-1; i++) {
                tempNode = tempNode.next;
            }
            return tempNode;
        }


        /**
         * 打印链表
         */
        public void outPut(){
            Node temp = head;
            while (temp != null){
                if (temp.next != null){
                    System.out.print(temp.data+"-->");
                }else{
                    System.out.print(temp.data);
                }
                temp=temp.next;
            }
        }
    }
