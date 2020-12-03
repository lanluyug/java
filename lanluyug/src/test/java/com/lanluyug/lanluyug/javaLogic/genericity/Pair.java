package com.lanluyug.lanluyug.javaLogic.genericity;

public class Pair<T, V> {// 可定义多个泛型，以逗号分隔
    T first;
    V second;
    public Pair(T first, V second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }

    public V getSecond(){
        return second;
    }
}
