package com.lanluyug.lanluyug.javaLogic.genericity;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 动态数组
 * @param <E>
 * 2）<？super E>用于灵活写入或比较， 使得对象可以写入父类型的容器，使得父类型的比较方法可以应用于子类对象，它不能被类型参数形式替代。
 * 3）<？>和<？extends E>用于灵活读取， 使得方法可以读取E或E的任意子类型的容器对象，它们可以用类型参数的形式替代，但通配符形式更为简洁。
 */
public class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;

    public DynamicArray(){
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(int minCapacity){
        int oldCapacity = elementData.length;
        if(oldCapacity >= minCapacity){
            return;
        }
        int newCapacity = oldCapacity * 2;
        if(newCapacity < minCapacity) newCapacity = minCapacity;
        elementData = Arrays.copyOf(elementData, newCapacity);

    }

    public void add(E e){
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    public E get(int index){
        return (E)elementData[index];
    }

    public int size(){
        return size;
    }

    public E set(int index, E element){
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

//    public <T extends Number> void addAll(DynamicArray<T> c){
//        for (int i = 0; i < c.size(); i++) {
//            add((E) c.get(i));
//        }
//    }

    /**
     * 通配符方式 ? 方式简写代码
     * @param c
     */
    public void addAll(DynamicArray<? extends E> c){
        for (int i = 0; i < c.size(); i++) {
            add(c.get(i));
        }
    }

    /**
     * 无限通配符;
     * 通配符只能读，不能写
     * 1）通配符形式都可以用类型参数的形式来替代，通配符能做的，用类型参数都能做。
     * 2）通配符形式可以减少类型参数，形式上往往更为简单，可读性也更好，所以，能用通配符的就用通配符。
     * 3）如果类型参数之间有依赖关系，或者返回值依赖类型参数，或者需要写操作，则只能用类型参数。
     * 4）通配符形式和类型参数往往配合使用，比如，上面的copy方法，定义必要的类型参数，使用通配符表达依赖，并接受更广泛的数据类型。
     */
    public static int indexOf(DynamicArray<?> arr, Object elm){
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).equals(elm)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 超类通配符
     */
    public void copyTo(DynamicArray<? super E> dest){
        for (int i = 0; i < size; i++) {
            dest.add(get(i));
        }
    }

    public E[] toArray(Class<E> type){
        Object copy = Array.newInstance(type, size);
        System.arraycopy(elementData, 0, copy,0, size);
        return (E[])copy;
    }
}
