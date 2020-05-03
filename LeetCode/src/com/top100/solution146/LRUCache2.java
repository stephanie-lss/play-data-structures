package com.top100.solution146;

import java.util.HashMap;

/**
 * @author LiSheng
 * @date 2020/5/3 15:17
 */
class LRUCache2 {

    class Node {
        public int key, val;
        public Node next, pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private class DoubleList {
        Node head, tail;
        private int size;

        public DoubleList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.next = head;
            size = 0;
        }

        public void addFirst(Node node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
            size++;
        }

        public Node removeLast() {
            if (tail.pre == head) {
                return null;
            }
            Node ret = tail.pre;
            remove(ret);
            return ret;
        }

        private void remove(Node target) {
            target.next.pre = target.pre;
            target.pre.next = target.next;
            target.next = null;
            target.pre = null;
            size--;
        }

        public int getSize() {
            return size;
        }
    }

    private DoubleList cache;
    private HashMap<Integer, Node> map;
    private int shold;

    public LRUCache2(int capacity) {
        cache = new DoubleList();
        map = new HashMap<>();
        shold = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cache.remove(cur);
            cache.addFirst(cur);
            return cur.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (!map.containsKey(key)) {
            if (cache.getSize() == shold) {
                Node delete = cache.removeLast();
                map.remove(delete.key);
            }
            cache.addFirst(node);
            map.put(key, node);
        } else {
            cache.remove(map.get(key));
            cache.addFirst(node);
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        System.out.println(cache.get(2));     // 返回  4
    }
}
