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


}
