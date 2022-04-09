package OldCode.Top_Interview_Quesitons_In_2018.LRU_Cache.Solution1;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        Integer i = lru.get(2);
        System.out.println(i);
        lru.put(2, 6);
        i = lru.get(1);
        System.out.println(i);

        lru.put(1, 5);
        lru.put(1, 2);
        i= lru.get(1);
        System.out.println(i);
        i= lru.get(2);
        System.out.println(i);

        System.out.println(lru);

    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 * LRUCache 内部的数据结构:
 * LinkedHashMap, 但是有点类似与队列(最老的放最前面,最新的放最后面)
 * 什么是最新的: 最新添加, 或者最新一次操作中被调用的结点
 * //存储长度
 * int lruSize;
 * //存储map
 * LinkedHashMap map;
 * //实例对象
 * LRUCache lru;
 */

class LRUCache {
    private int lruSize;
    private LinkedHashMap map;
    //LRUCache lru;

    public LRUCache() {
        lruSize = 0;
        //lru = new LRUCache();
        map = new LinkedHashMap();
    }

    public LRUCache(int capacity) {
        this();
        lruSize = capacity;
    }

    /**
     * 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
     * 如果存在, 则获取值, 并且将结点移动到最后面
     *
     * @param key
     * @return
     */
    public int get(int key) {
        Integer result = -1;
        if (map.containsKey(key)) {
            //移动位置到最后面
            result = (Integer) map.get(key);

            map.remove(key);
            map.put(key, result);

            return result;
        } else {
            result = -1;
        }

        return result;
    }

    /**
     * put操作: 如果密钥不存在，则写入其数据值。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
     * 1.判断密钥是否存在, 不存在则写入值, 若存在则替换
     * 2. 当容量已经到达上限时, 则删除最少使用的数据值(键值对)
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }


        //判断是否到底上限
        if (map.size() >= lruSize) {
            //如果到底上限,则清除一个结点
            Set set = map.keySet();
            Iterator iterator = set.iterator();
            Integer temp = -1;
            //去除第一个
            while (iterator.hasNext()) {
                temp = (Integer) iterator.next();
                if (map.size() >= 1) {
                    map.remove(temp);
                }
                break;
            }
        }
        //判断是否存在密钥
        if (!map.containsKey(key)) {
            map.put(key, value);
        }

    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "lruSize=" + lruSize +
                ", map=" + map +
                '}';
    }
}

