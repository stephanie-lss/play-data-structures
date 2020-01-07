import java.io.IOException;
import java.util.ArrayList;

/**
 * @author LiSheng
 * @date 2020/1/4 16:51
 * 优化思路：当添加或者删除节点是，该节点以及该节点的相关父节点就不需要维护平衡了
 */
public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

        public Node(K key) {
            this(key, null);
        }

    }

    private Node root;
    private int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    /**
     * 判断该二叉树是否是一棵平衡二叉树
     *
     * @return
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * 判断以该结点作为根的树是否是平衡二叉树
     *
     * @param node
     * @return
     */
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        if (Math.abs(getBalanceFactor(node)) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    /**
     * 返回当前节点的高度值
     *
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 获得节点node的平衡因子
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

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
        return nodeBalance(node);
    }


    //           y                          x
    //          / \                       /   \
    //         x  T4      向右旋转(y)     z     y
    //        / \       ----------->    / \   / \
    //       z  T3                     T1 T2 T3 T4
    //      / \
    //     T1 T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        x.right = y;
        y.left = T3;

        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }


    //     y                        x
    //    / \                     /   \
    //   T1  x    向左旋转(y)     y     z
    //      / \  ----------->  / \   / \
    //     T2  z              T1 T2 T3 T4
    //        / \
    //       T3 T4
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;
        x.left = y;
        y.right = T2;

        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
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

        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            if (node.left == null) {
                //待删除节点左子树为空
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                //待删除节点右子树为空
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                //左右子树均不为空的情况
                Node successor = minmum(node.right);
                successor.right = remove(node.right, successor.key);
//                successor.right = removeMin(node.right);
                //因为removeMin中的size--了，但其实这个最小节点并没有被删除，
                //successor保存了该节点的内存地址
                size++;
                successor.left = node.left;
                node.left = null;
                node.right = null;
                //原本的根节点node被删除了，因此需要size--
                size--;
                retNode = successor;
            }
        }
        return nodeBalance(retNode);
    }

    /**
     * 以node为根的二叉树平衡过程
     *
     * @param node
     * @return
     */
    private Node nodeBalance(Node node) {
        if (node == null) {
            return null;
        }
        //更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        /*if (Math.abs(balanceFactor) > 1) {
            System.out.println("unbalance : " + balanceFactor);
        }*/
        //平衡维护
        //LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            //右旋转
            return rightRotate(node);
        }
        //RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            //左旋转
            return leftRotate(node);
        }
        //LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
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
        AVLTree<String, Integer> avlTree = new AVLTree<>();
        ReadFile readFile = new ReadFile();
        String content = readFile.readFileContent("F:\\Github\\play data-structures\\TestTools\\src\\test.txt");
        String[] words = content.split(" ");
        for (String word : words) {
            if (avlTree.contains(word)) {
                avlTree.set(word, avlTree.get(word) + 1);
            } else {
                avlTree.add(word, 1);
            }
        }
        System.out.println("Total different word：" + avlTree.getSize());
        System.out.println("Frequency of sun：" + avlTree.get("sun"));
        System.out.println("Frequency of he：" + avlTree.get("he"));

        System.out.println("is BST : " + avlTree.isBST());
        System.out.println("is Balanced : " + avlTree.isBalanced());

        for (String word : words) {
            avlTree.remove(word);
            if (!avlTree.isBST() || !avlTree.isBalanced()) {
                throw new RuntimeException("Error");
            }
        }
    }
}
