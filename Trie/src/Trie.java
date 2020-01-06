import java.util.TreeMap;

/**
 * @author LiSheng
 * @date 2020/1/5 16:46
 */
public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    //单词数量
    public int getSize() {
        return size;
    }

    //向Trie添加一个新单词word，非递归算法
    public void addNR(String word) {
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
            size++;
        }
    }

    //向Trie添加一个新单词word，递归算法
    public void add(String word) {
        add(root, word, 0);
    }

    //向以node为根节点的trie树中添加字符串word
    private void add(Node node, String word, int index) {
        if (index == word.length()) {
            if (!node.isWord) {
                node.isWord = true;
                size++;
            }
            return;
        }
        char addChar = word.charAt(index);
        if (node.next.get(addChar) != null) {
            add(node.next.get(addChar), word, index + 1);
            return;
        }
        node.next.put(addChar, new Node());
        add(node.next.get(addChar), word, index + 1);
    }

    //查询单词word是否在Trie中，非递归算法
    public boolean containsNR(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean contains(String word) {
        return contains(root, word, 0);
    }

    //查询单词word是否在Trie中，递归算法
    private boolean contains(Node node, String word, int index) {
        if (word.length() == 0) {
            throw new IllegalArgumentException("Word cannot empty. ");
        }
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (node.next.get(c) == null) {
            return false;
        }
        return contains(node.next.get(c), word, index + 1);
    }

    // 查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    //删除Trie树中的字符串word
    public boolean remove(String word) {
        return remove(root, word, 0);
    }

    //删除字符串，递归算法
    private boolean remove(Node node, String word, int index) {
        //递归终止条件
        if (index == word.length()) {
            if (node.next == null) {
                node = null;
            } else {
                node.isWord = false;
            }
            return true;
        }
        char delChar = word.charAt(index);
        if (node.next.get(delChar) == null) {
            return false;
        }
        boolean ret = remove(node.next.get(delChar), word, index + 1);
        if (ret) {
            if (node.next == null) {
                node = null;
            }
        }
        return ret;
    }
}
