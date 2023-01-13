package test.datastructure;

public class NodeTest {

    public int data;//数据
    public NodeTest next;//下个节点指针

    public NodeTest(int data) {
        this.data = data;
    }

    public NodeTest(int data, NodeTest next){
        this.data = data;
        this.next = next;
    }


}
