import java.util.TreeMap;

/**
 * @author LiSheng
 * @date 2020/1/5 21:23
 */
public class TrieMap implements Map<String, Integer> {

    private class Node {
        public int count;
        public String key;
        public Integer value;
        TreeMap<Character, Node> next;

        public Node(int count, String key, Integer value) {
            this.count = count;
            this.key = key;
            this.value = value;
            next = new TreeMap<>();
        }

        public Node(Integer value) {
            this(0, null, value);
        }

        public Node() {
            this(0);
        }
    }

    private Node root;
    private int size;

    public TrieMap() {
        root = new Node();
        size = 0;
    }

    public int count(String key) {
        if (key.length() == 0) {
            throw new IllegalArgumentException("Word cannot empty! ");
        }
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return cur.count;
    }

    @Override
    public void add(String key, Integer value) {
        if (key.length() == 0) {
            throw new IllegalArgumentException("Word cannot empty! ");
        }
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                if (i == key.length() - 1) {
                    cur.next.put(c, new Node(value));
                } else {
                    cur.next.put(c, new Node());
                }
            }
            cur = cur.next.get(c);
        }
        if (cur.count == 0) {
            cur.count = 1;
            size++;
        } else {
            cur.count++;
        }
    }

    @Override
    public Integer remove(String key) {
/*        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                throw new IllegalArgumentException("Error");
            }
            cur = cur.next.get(c);
        }
        if (!cur.next.keySet().isEmpty()) {
            cur.count = 0;
            return cur.value;
        }
        cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.keySet().size() == 1) {
                cur.next.put(c, null);
            }
            cur = cur.next.get(c);
        }*/
        return 0;
    }

    @Override
    public boolean contains(String key) {
        if (key.length() == 0) {
            throw new IllegalArgumentException("Word cannot empty! ");
        }
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.count != 0;
    }

    @Override
    public Integer get(String key) {
        if (key.length() == 0) {
            throw new IllegalArgumentException("Word cannot empty! ");
        }
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return cur.value;
    }

    @Override
    public void set(String key, Integer newValue) {
        if (key.length() == 0) {
            throw new IllegalArgumentException("Word cannot empty! ");
        }
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                return;
            }
            cur = cur.next.get(c);
        }
        cur.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
