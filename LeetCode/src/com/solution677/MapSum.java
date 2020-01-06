package com.solution677;

import java.util.TreeMap;

class MapSum {

    private class Node {
        public int value;
        public TreeMap<Character, Node> next;

        public Node(int value) {
            next = new TreeMap<>();
            this.value = value;
        }

        public Node() {
            this(0);
        }
    }

    private Node root;
    private int sum = 0;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);

    }

    //返回以node为根节点的搜索子树包含的value值的和
    private int sum(Node node) {
        int res = node.value;

        for (Character c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */