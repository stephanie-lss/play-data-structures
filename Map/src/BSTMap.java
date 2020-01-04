/**
 * @author LiSheng
 * @date 2020/1/4 16:51
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(K key) {
            this(key, null);
        }

    }

    private Node root;
    private int size;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 向一node为根的二分搜索树中插入元素e，递归算法
     * 返回新插入节点后二分搜索树的根
     *
     * @param node
     * @param key
     * @param value
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    //返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    /**
     * 返回以node为根节点的二分搜素树的最小节点元素e，递归算法
     *
     * @param node
     * @return
     */
    private Node minmum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minmum(node.left);
    }

    /**
     * 删除掉以node为根的二分搜索树的最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删掉以node为根的二分搜索树中键为key的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @param key
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;

            } else {
                Node successor = minmum(node.right);
                successor.right = removeMin(node.right);
                //因为removeMin中的size--了，但其实这个最小节点并没有被删除，
                //successor保存了该节点的内存地址
                size++;
                successor.left = node.left;
                node.left = null;
                node.right = null;
                //原本的根节点node被删除了，因此需要size--
                size--;
                return successor;
            }
        }
    }

    /**
     * 删除键为key的节点
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        } else {
            node.value = newValue;
        }
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
