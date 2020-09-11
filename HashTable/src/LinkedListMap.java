import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/1/4 16:18
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node(null, null, null);
        this.size = 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur;
            } else {
                cur = cur.next;
            }
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (key.equals(pre.next.key)) {
                break;
            }
            pre = pre.next;
        }
        if (pre.next != null) {
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        } else {
            node.value = newValue;
        }
    }

    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        Node cur = dummyHead.next;
        while (cur != null) {
            keySet.add(cur.key);
            cur = cur.next;
        }
        return keySet;
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
