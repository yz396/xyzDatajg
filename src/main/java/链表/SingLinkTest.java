package 链表;

import org.junit.Test;

public class SingLinkTest {

    //测试头插法
    @Test
    public void test1(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.loop2(System.out::println);
    }


    //测试迭代器遍历
    @Test
    public void test2(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    //测试尾插法
    @Test
    public void test3() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.loop2(System.out::println);
    }

    //测试索引是否正常
    @Test
    public void test4() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

       // list.test();
        int i = list.get(3);
        System.out.println(i);
    }
}
