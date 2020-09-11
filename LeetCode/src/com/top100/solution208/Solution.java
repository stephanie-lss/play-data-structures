package com.top100.solution208;

import java.util.TreeMap;

/**
 * @author LiSheng
 * @date 2020/4/28 15:38
 */
class Trie {
    private Node root;

    private class Node {
        private TreeMap<Character, Node> next;
        private boolean isWord;

        public Node(boolean isWord) {
            this.next = new TreeMap<>();
            this.isWord = isWord;
        }

        public Node() {
            this(false);
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        //获取根节点
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cur.next.putIfAbsent(c,new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    public void insertR(String word) {
        //获取根节点
        insertHelper(word, 0, root);
    }

    private void insertHelper(String word, int index, Node node) {
        if (index == word.length()) {
            node.isWord = true;
            return;
        }
        node.next.putIfAbsent(word.charAt(index), new Node());
        insertHelper(word, index + 1, node.next.get(word.charAt(index)));
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node cur = root;
        return searchTrie(word, 0, cur);
    }

    private boolean searchTrie(String word, int index, Node cur) {
        if (index == word.length()) {
            return cur.isWord;
        }
        if (cur.next.containsKey(word.charAt(index))) {
            return searchTrie(word, index + 1, cur.next.get(word.charAt(index)));
        } else {
            return false;
        }
    }

    public boolean searchNR(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            } else {
                cur = cur.next.get(c);
            }
        }
        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPre(prefix, 0, root);
    }

    private boolean searchPre(String prefix, int index, Node cur) {
        if (index == prefix.length()) {
            return true;
        }
        if (cur.next.containsKey(prefix.charAt(index))) {
            return searchPre(prefix, index + 1, cur.next.get(prefix.charAt(index)));
        } else {
            return false;
        }
    }

    public boolean startsWithNR(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!cur.next.containsKey(prefix.charAt(i))) {
                return false;
            } else {
                cur = cur.next.get(prefix.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));// 返回 true
        System.out.println(trie.search("app"));// 返回 true
        System.out.println(trie.startsWith("app"));// 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));// 返回 true
    }
}
