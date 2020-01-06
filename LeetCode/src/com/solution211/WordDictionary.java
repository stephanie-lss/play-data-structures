package com.solution211;

import java.util.Set;
import java.util.TreeMap;

class WordDictionary {
    private class Node {
        boolean isWord;
        TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        addWord(root, word, 0);
    }

    private void addWord(Node node, String word, int index) {
        if (index == word.length()) {
            if (!node.isWord) {
                node.isWord = true;
            }
            return;
        }
        char c = word.charAt(index);
        if (node.next.get(c) == null) {
            node.next.put(c, new Node());
            addWord(node.next.get(c), word, index + 1);
        } else {
            addWord(node.next.get(c), word, index + 1);
        }
    }

    public void addWordNR(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            } else {
                return search(node.next.get(c), word, index + 1);
            }
        } else {
            Set<Character> keySet = node.next.keySet();
            if (!keySet.isEmpty()) {
                for (Character key : keySet) {
                    if (search(node.next.get(key), word, index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("at");
//        obj.addWord("and");
//        obj.addWord("an");
//        obj.addWord("add");
        obj.addWord("bat");
        System.out.println(obj.search(".at"));
        System.out.println(obj.search(".at"));

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */