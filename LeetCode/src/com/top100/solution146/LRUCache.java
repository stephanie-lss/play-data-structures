package com.top100.solution146;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/3 12:29
 */
class LRUCache {
    private LinkedHashMap<Integer, Integer> data;
    private int size;

    public LRUCache(int capacity) {
        data = new LinkedHashMap<>();
        size = capacity;
    }

    public int get(int key) {
        if (!data.containsKey(key)) {
            return -1;
        }
        Integer ret = data.remove(key);
        data.put(key, ret);
        return ret;
    }

    public void put(int key, int value) {
        if (data.containsKey(key)) {
            data.remove(key);
        } else {
            if (data.size() == size) {
                data.remove(data.entrySet().iterator().next().getKey());
            }
        }
        data.put(key, value);
    }

    public static void main(String[] args) {
                LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        System.out.println(cache.get(2));     // 返回  4
//        LRUCache cache = new LRUCache(2);

        /*cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));      // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));      // 返回 -1 (未找到)
        System.out.println(cache.get(3));      // 返回 -1 (未找到)
        System.out.println(cache.get(4));      // 返回 -1 (未找到)*/
    }
}