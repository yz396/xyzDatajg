package 链表;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList implements Iterable<Integer>{
    private Node head = null; //头指针


    //迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        //匿名内部类
        return new Iterator<Integer>() {
            Node p = head;
            @Override
            public boolean hasNext() { //询问是否有下一个元素
                return p != null;
            }

            @Override
            public Integer next() {  //返回当前元素的值，并返回下一个元素
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }

    //节点类
    private static class Node{
        int value; //值
        Node next; //下一个节点指针

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    //添加新节点,在头部添加（头插法）
    public void addFirst(int value) {
        //1.链表为空的情况
        //head = new Node(value, null);
        //2.链表非空的情况
        head = new Node(value, head);
    }

    //添加新节点，尾部插入（尾插法） 尾插法比头插法难在不知道尾节点是什么，因此先写一个查找尾节点的方法
    private Node findLast() {
        if(head == null){  //空链表，没有尾节点
            return null;
        }
        Node p = head;

//        for(p = head; p.next != null; p = p.next){
//
//        }

        while(p.next != null){
            p = p.next;
        }
        return p;
    }
    public void addLast(int value) {
        Node last = findLast();
        if(last == null){
            addFirst(value);
            return;
        }
        last.next = new Node(value,null);
    }


    //遍历列表
    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while(p != null){
            consumer.accept(p.value);
            p = p.next;
        }
    }
    public void loop2(Consumer<Integer> consumer){
        for(Node p = head; p != null; p = p.next){
            consumer.accept(p.value);
        }
    }

    /* 根据索引查找元素，由于链表不像数组，所以链表没有索引。
    *写一个方法给链表拟添加索引
    */
    /*public void test() {
        int i = 0;
        for (Node p = head; p != null; p = p.next,i++){
            System.out.println(p.value + "索引是：" + i);
        }
    }*/
    //找节点，没有找到就返回null
    private Node findNode(int index) {  //该方法与get联系起来，因此设置为private
        int i = 0;
        for(Node p = head; p != null; p = p.next,i++){
            if(i == index){
                return p;
            }
        }
        return null; //没有找到节点
    }
    //返回节点值
    public int get(int index) {
        Node node = findNode(index);
        if(node == null){
            throw new IllegalArgumentException(
                    String.format("index [%d] 不合法%n", index)
            );
        }
        return node.value;
    }

    /* 向链表任意索引位置添加节点（索引合法）
     *关键找到插入节点的上一个节点
     *
     */
    public void insert(int index, int value){
        Node prev = findNode(index - 1);
        if (prev != null) {
            prev.next = new Node(value, prev.next);
        }
    }

}
