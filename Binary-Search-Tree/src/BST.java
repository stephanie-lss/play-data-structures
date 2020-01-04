import java.util.*;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/1/2 21:13
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }


    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e，递归算法
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树，递归算法
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树的前序遍历非递归算法
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            System.out.print(node.e);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树，递归算法
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历以node为根的二分搜索树，递归算法
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e);
    }

    /**
     * 层序遍历二分搜索树，非递归算法
     */
    public void levelOrderNR() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.print(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public E minmum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minmum(root).e;
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
     * 返回以node为根节点的二分搜素树的最小节点元素e，非递归算法
     *
     * @return
     */
    public E minmumNR() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty.");
        }
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.e;
    }

    public E maxmum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maxmum(root).e;
    }

    /**
     * 返回以node为根节点的二分搜素树的最大节点元素e
     *
     * @param node
     * @return
     */
    private Node maxmum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxmum(node.right);
    }

    /**
     * 返回以node为根节点的二分搜素树的最大节点元素e，非递归算法
     *
     * @return
     */
    public E maxmumNR() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty.");
        }
        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.e;
    }

    public void add(E e) {
        /*if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }*/
        root = add(root, e);
    }

    /**
     * 向一node为根的二分搜索树中插入元素e，递归算法
     * 返回新插入节点后二分搜索树的根
     *
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {
        /*if (node.e.equals(e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }*/
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 从二分搜索树中删除最小值所在节点，返回最小值
     *
     * @return
     */
    public E removeMin() {
        E ret = minmum();
        root = removeMin(root);
        return ret;
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
     * 从二分搜索树中删除最大值所在节点，返回最大值
     *
     * @return
     */
    public E removeMax() {
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树的最大节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删掉以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @param e
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
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
     * 删掉以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @param e
     */
    private Node removePre(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = removePre(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = removePre(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node predecessor = maxmum(node.left);
            predecessor.left = removeMax(node.left);
            size++;
            predecessor.right = node.right;
            node.right = node.left = null;
            size--;
            return predecessor;
        }
    }

    public E floor(E num) {
        if (size == 0 || num.compareTo(minmum()) < 0) {
            return null;
        }
        return floor(root, num).e;
    }

    /**
     * 寻找以node为根的二叉搜索树中比数字num小的最大值
     * 返回floor节点
     * @param node
     * @param num
     * @return
     */
    private Node floor(Node node, E num) {
        if (node == null) {
            return null;
        }
        //直接相等的话表明是节点本身
        if (num.compareTo(node.e) == 0) {
            return node;
        }
        if (num.compareTo(node.e) < 0) {
            return floor(node.left, num);
        }

        Node tmpNode = floor(node.right, num);
        if (tmpNode != null) {
            return tmpNode;
        }
        return node;
    }

    public E ceil(E num) {
        if (num.compareTo(maxmum()) > 0 || size == 0) {
            return null;
        }
        return ceil(root, num).e;
    }

    /**
     * 寻找以node为根的二叉搜索树中比数字num大的最小值
     * 返回num的ceil节点
     * @param node
     * @param num
     * @return
     */
    private Node ceil(Node node, E num) {
        if (node == null) {
            return null;
        }
        if (num.compareTo(node.e) == 0) {
            return node;
        }

        if (num.compareTo(node.e) > 0) {
            return ceil(node.right, num);
        }
        Node tmpNode = ceil(node.left,num);
        if (tmpNode != null){
            return tmpNode;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     *
     * @param node
     * @param depth
     * @param res
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
