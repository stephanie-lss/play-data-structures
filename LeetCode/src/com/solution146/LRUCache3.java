package com.solution146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/7/25 12:45
 */
public class LRUCache3 {

    private Map<Integer, Node> cache;
    private DoubleList doubleList;
    private int size;

    private class Node {
        int key, value;
        Node pre, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            head.pre = null;
            tail.pre = head;
            tail.next = null;
            this.size = 0;
        }

        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = null;
            node.next = null;
            size--;
        }

        public void addFirst(Node node) {
            node.next = head.next;
            node.pre = head;
            node.next.pre = node;
            head.next = node;
            size++;
        }

        public Node removeLast() {
            Node ret = tail.pre;
            tail.pre = ret.pre;
            tail.pre.next = tail;
            ret.next = null;
            ret.pre = null;
            size--;
            return ret;
        }
    }

    public LRUCache3(int capacity) {
        this.cache = new HashMap<>();
        this.doubleList = new DoubleList();
        this.size = capacity;
    }

    public int get(int key) {
        if (cache.isEmpty() || !cache.containsKey(key)) {
            return -1;
        }
        Node ret = cache.get(key);
        doubleList.remove(ret);
        doubleList.addFirst(ret);
        return ret.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            doubleList.remove(cache.get(key));
            cache.remove(key);
        } else {
            if (doubleList.size == size) {
                Node ret = doubleList.removeLast();
                cache.remove(ret.key);
            }
        }
        Node addNode = new Node(key, value);
        doubleList.addFirst(addNode);
        cache.put(key, addNode);
    }

    public static void main(String[] args) {
        LRUCache3 cache = new LRUCache3(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
