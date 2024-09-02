import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer>{

    //动态数组
    private int size = 0; //逻辑大小
    private int capacity = 8; //容量
    private int[] array = new int[capacity]; //虽然动态数组，但是底层还是静态数组


    //新增的元素作为最后一个加入动态数组
    public void addLast(int element) {
  //      array[size] = element;
  //      size++;
        add(size, element);
    }

    //向数组中某一个位置加入数据
    public void add(int index, int element) {

        //扩容检查


        if(index >= 0 && index < size){
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
            size++;
        }else if(index == size){ //如果插入的位置等于size，就是在数组最后插入。
            array[index] = element;
            size++;
        }else {
            System.out.println("输入索引有误");
        }
    }

    public int get(int index){
        return array[index];
    }

    public void foreach(Consumer<Integer> consumer){
        for(int i = 1; i < size; i++){
            consumer.accept(array[i]);
        }
    }

    //迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() {   //有没有下一个元素
                return i<size;
            }

            @Override
            public Integer next() {   //返回当前元素，并移动到下一个元素
                return array[i++];
            }
        };
    }

    //流遍历
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size)); //含头不含尾，0索引处元素会返回，但不会返回size索引，所以最后一个返回的索引是size-1
    }

    //删除数组元素
    public int remove(int index) {
        int a = array[index];
        System.arraycopy(array, index + 1, array, index, size-index-1);
        size--;
        return a;
    }


}
