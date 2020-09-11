package com.solution146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/25 8:31
 */
class LRUCache {
    private class Node {
        private int key;
        private int val;
        private Node next;
        private Node pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private class DoubleList {
        private Node head;
        private Node tail;
        private int size;

        public DoubleList() {
            this.size = 0;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            head.pre = null;
            tail.pre = head;
            tail.next = null;
        }

        public void addFirst(Node node) {
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
            node.pre = head;
            size++;
        }

        public Node removeLast() {
            Node ret = tail.pre;
            tail.pre = ret.pre;
            ret.pre.next = ret.next;
            ret.next = null;
            ret.pre = null;
            size--;
            return ret;
        }

        public void remove(Node node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.next = null;
            node.pre = null;
            size--;
        }

        public int getSize() {
            return size;
        }
    }

    private Map<Integer, Node> mapper;
    private DoubleList list;
    private int size;

    public LRUCache(int capacity) {
        mapper = new HashMap<>(capacity);
        list = new DoubleList();
        size = capacity;
    }

    public int get(int key) {
        if (mapper.containsKey(key)) {
            Node node = mapper.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (mapper.containsKey(key)) {
            list.remove(mapper.get(key));
            Node node = new Node(key, value);
            list.addFirst(node);
            mapper.put(key, node);
        } else {
            Node node = new Node(key, value);
            if (list.getSize() < size) {
                list.addFirst(node);
            } else {
                Node del = list.removeLast();
                mapper.remove(del.key);
                list.addFirst(node);
            }
            mapper.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));// 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));      // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));      // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}
