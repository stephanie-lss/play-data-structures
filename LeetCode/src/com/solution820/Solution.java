package com.solution820;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author LiSheng
 * @date 2020/3/28 10:36
 */
class Solution {
    public int minimumLengthEncoding(String[] words) {
        int size = 0;
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());
        Trie trie = new Trie();

        for (String word : words) {
            size += trie.insert(word);
        }
        return size;
    }

    public static void main(String[] args) {
        String[] words = {"carton", "car","bell"};
        System.out.println(new Solution().minimumLengthEncoding(words));
    }
}

class Trie {
    Node root;

    private class Node {
        private TreeMap<Character, Node> next;


        public Node() {
            next = new TreeMap<>();
        }
    }

    public Trie() {
        root = new Node();
    }

    public int insert(String word) {
        Node cur = root;
        boolean flag = false;
        for (int i = word.length()-1; i >=0; i--) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                flag = true;
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        return flag ? word.length() + 1 : 0;
    }


}
