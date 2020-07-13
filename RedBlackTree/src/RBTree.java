import java.io.IOException;

/**
 * @author LiSheng
 * @date 2020/1/7 9:44
 * Title：左倾红黑树
 * 红黑树添加和删除操作占优，查询、修改操作AVL占优，但总体统计性能红黑树占优；
 * 添加完全随机的数据二分搜索树更好，算法复杂度较低，不会退化成链表
 */
public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        boolean color;

        public Node(K key, V value, boolean color) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = color;
        }

        public Node(K key, V value) {
            this(key, value, RED);
        }

        public Node(K key) {
            this(key, null);
        }

        public Node() {
            this(null);
        }
    }

    private Node root;
    private int size;

    public RBTree() {
//        this.root = new Node(null, null, BLACK);
        this.root = null;
        this.size = 0;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    //     node                          x
    //    /   \                        /  \
    //   T1    x    向左旋转(node)    node  T3
    //        / \  -------------->  /   \
    //      T2  T3                 T1   T2

    /**
     * 当向node节点（左右节点为空）右侧添加一个红色节点x时需要左旋转，
     * 使得继续保持红黑树的性质（黑红——>红黑   红红——>红红），左旋转
     * 之前相当于是2-3树中的三节点（最左侧元素为根节点，黑色或者红色），
     * 因为旋转只是一个子过程，因此旋转之后也为三节点，只是此时三节点的
     * 最左侧数字为红色（根节点的左孩子）。
     * node.color = RED是因为原子树的根节点node还要保持和x的三节点状态，因此置为红
     *
     * @param node
     * @return
     */
    private Node leftRotate(Node node) {
        Node x = node.right;

        node.right = x.left;
        x.left = node;

        //维护颜色
        x.color = node.color;
        node.color = RED;
        return x;
    }

    //     node                        x
    //    /   \                      /  \
    //   x    T2    向右旋转(node)   y  node
    //  / \       -------------->     /   \
    // y  T1                         T1   T2
    private Node rightRotate(Node node) {
        Node x = node.left;
        //右旋转
        node.left = x.right;
        x.right = node;

        //维护颜色
        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 颜色翻转，当向一个子树根节点为黑节点，并且其左右孩子都是红色时需要颜色反转
     * node.color = RED是因为子树的根节点还要继续向上融合，因此置为红
     *
     * @param node
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 向红黑树中添加元素
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        root = add(root, key, value);

        //保持最终的根节点为黑色
        root.color = BLACK;
    }

    /**
     * 向一node为根的红黑树中插入元素e，递归算法
     * 返回新插入节点后红黑树的根
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

        //颜色调整
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
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
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        } else {
            node.value = newValue;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("MADAME BOVARY");
        ReadFile readFile = new ReadFile();
        String content = readFile.readFileContent("G:\\GitHub\\data-structures\\TestTools\\src\\test.txt");
        String[] words = content.split(" ");
        // Test 红黑树
        long startTime = System.nanoTime();
        RBTree<String, Integer> rbTree = new RBTree<>();
        for (String word : words) {
            if (rbTree.contains(word)) {
                rbTree.add(word, rbTree.get(word) + 1);
            } else {
                rbTree.add(word, 1);
            }
        }
        for (String word : words) {
            rbTree.contains(word);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL：" + time + " s.");
        System.out.println("*********");
        System.out.println(rbTree.getSize() + " " + rbTree.getSize());
        System.out.println(rbTree.get("he") + " " + rbTree.get("he"));
        System.out.println(rbTree.get("is") + " " + rbTree.get("is"));

    }
}
