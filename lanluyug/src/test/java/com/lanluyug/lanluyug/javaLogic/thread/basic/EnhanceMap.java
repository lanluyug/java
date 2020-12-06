package com.lanluyug.lanluyug.javaLogic.thread.basic;

import java.util.Collections;
import java.util.Map;

/**
 * 加synchronized注意事项：
 * 1。复合操作，比如先检查，后更新（本例）
 * 2。伪同步
 * 3。迭代
 *
 * 一般来说，大量使用synchronized的集合操作，是效率极低的；
 * java有一些专门为并发涉及的容器类,它们没有使用synchronized
 * 1。CopyOnWriteArrayList
 * 2. ConcurrentHashMap
 * 3. ConcurrentLinkedQueue
 * 4. concurrentSkipListSet
 */
public class EnhanceMap<K,V> {
    Map<K,V> map;

    public EnhanceMap(Map<K,V> map){
        this.map = Collections.synchronizedMap(map);
    }
    public V putIfAbsent(K key, V value){
        V old = map.get(key);
        if(old != null){
            return old;
        }
        return map.put(key, value);
    }
    public V put(K key, V value){
        return map.put(key,value);
    }
}
