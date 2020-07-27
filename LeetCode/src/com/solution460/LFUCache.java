package com.solution460;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/4/5 10:04
 */
class LFUCache {
    private Map<Integer, Node> cache;
    private Queue<Node> queue;
    private int size;
    private int idx = 0;
    private int capacity;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        if (capacity > 0) {
            this.queue = new PriorityQueue<>(capacity);
        }
        this.capacity = capacity;
    }

    private class Node implements Comparable<Node> {
        private int key;
        private int val;
        private int count;
        int idx;

        public Node() {
        }

        public Node(int key, int val, int idx) {
            this.key = key;
            this.val = val;
            this.count = 1;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            if (this.count > o.count) {
                return 1;
            } else if (this.count < o.count) {
                return -1;
            } else {
                return this.idx - o.idx;
            }
        }
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        node.count++;
        node.idx = idx++;
        queue.remove(node);
        queue.offer(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.val = value;
            node.count++;
            node.idx = idx++;
            queue.remove(node);
            queue.offer(node);
        } else {
            if (size == capacity) {
                Node top = queue.poll();
                cache.remove(top.key);
                size--;
            }
            Node newNode = new Node(key, value, idx++);
            queue.offer(newNode);
            cache.put(key, newNode);
            size++;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */