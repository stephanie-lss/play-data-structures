package com.solution146;

import java.util.LinkedHashMap;

/**
 * @author LiSheng
 * @date 2020/7/25 12:31
 */
public class LRUCache2 {

    private LinkedHashMap<Integer, Integer> cache;
    private int size;

    public LRUCache2(int capacity) {
        this.cache = new LinkedHashMap<>();
        this.size = capacity;
    }

    public int get(int key) {
        if (cache.isEmpty() || !cache.containsKey(key)) {
            return -1;
        }
        Integer ret = cache.remove(key);
        cache.put(key, ret);
        return ret;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        } else {
            if (cache.size() == size) {
                cache.remove(cache.keySet().iterator().next());
            }
        }
        cache.put(key, value);
    }
}
