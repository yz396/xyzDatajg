import org.junit.Test;

import java.security.PublicKey;

public class testDA {

    @Test
    public void test1(){
        DynamicArray dy = new DynamicArray();
        dy.addLast(1);
        dy.addLast(2);
        dy.addLast(3);
        dy.addLast(4);
        dy.addLast(5);


        dy.add(2, 10086);
        dy.foreach((element)->{
            System.out.println(element);
        });
    }

    @Test
    public void test2(){

        DynamicArray dy = new DynamicArray();
        dy.addLast(1);
        dy.addLast(2);
        dy.addLast(3);
        dy.addLast(4);
        dy.addLast(5);

        for(Integer element : dy){
            System.out.println(element);
        }
    }

    @Test
    public void test3() {
        DynamicArray dy = new DynamicArray();
        dy.addLast(1);
        dy.addLast(2);
        dy.addLast(3);
        dy.addLast(4);
        dy.addLast(5);

        dy.stream().forEach(element -> {
            System.out.println(element);
        });
    }

    @Test
    public void test4() {
        DynamicArray dy = new DynamicArray();
        dy.addLast(1);
        dy.addLast(2);
        dy.addLast(3);
        dy.addLast(4);
        dy.addLast(5);


        int a = dy.remove(3); //把下标为3的4删除
        System.out.println("删除的元素为" + a);
        for(Integer element : dy){
            System.out.println(element);
        }

    }
}
