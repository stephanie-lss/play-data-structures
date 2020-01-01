public class RecursionnLinkedList<E extends Comparable<E>> {
    //链表节点内部类
    private class Node{
        E e;
        Node next;
        public Node(E _e,Node _next){
            this.e = _e;
            this.next = _next;
        }
        public Node(E _e){
            this(_e, null);
        }
        public Node(){
            this(null, null);
        }
    }
    //头节点
    private Node head;
    //链表实际存储大小
    private int size;
    //无参构造函数
    public RecursionnLinkedList(){
        this.head = null;
        this.size = 0;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return this.size == 0;
    }
    public int size(){
        return this.size;
    }
    //在链表头添加节点
    public void addFirst(E e){
        add(0, e);
    }
    //在链表尾添加节点
    public void addLast(E e){
        add(size, e);
    }
    //在链表指定位置添加节点
    public void add(int index,E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is error.");
        }
        head = add(index, e, head);
    }
    //通过递归实现链表的添加
    private Node add(int index,E e,Node node){
        if (index == 0 && node == null) {
            this.size++;
            return new Node(e);
        }
        if (index == 0) {
            this.size++;
            Node newNode = new Node(e);
            //newNode.next = node.next;
            newNode.next = node;
            //node.next = newNode;
            return newNode;
        }
        node.next = add(index - 1, e, node.next);
        return node;
    }
    /**
     * 用于根据索引查找对应的节点,
     * @param index
     * @param node
     * @return 相应的节点对象
     */
    private Node getElementByIndex(int index,Node node){
        if (index == 0 && node != null) {
            return node;
        }
        Node ret = getElementByIndex(index - 1, node.next);
        return ret;
    }
    //删除链表头节点
    public E removeFirst(){
        return remove(0);
    }
    //删除链表尾结点
    public E removeLast(){
        return remove(size - 1);
    }
    //删除指定位置节点,并返回删除节点值
    public E remove(int index){
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is error.");
        }
        Node ret = getElementByIndex(index, head);
        head = remove(index, head);
        return ret.e;
    }
    //递归删除节点值
    private Node remove(int index,Node node){
        if (node == null) {
            return node;
        }
        if (index == 0) {
            Node delNode = node;
            node = delNode.next;
            delNode.next = null;
            this.size--;
            return node;
        }
        node.next = remove(index - 1, node.next);
        return node;
    }
    //修改指定位置节点的值,通过递归实现
    public void set(int index,E e){
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is error.");
        }
        set(index, e, head);
    }
    private void set(int index,E e,Node node){
        if (node == null) {
            return;
        }
        if (index == 0) {
            node.e = e;
        }
        set(index - 1, e, node.next);
        return;
    }
    //获取链表头节点的值
    public E getFirst(){
        return get(0);
    }
    //获取链表尾结点的值
    public E getLast(){
        return get(size - 1);
    }
    //获取链表制定位置的值,通过递归实现
    public E get(int index){
        if (isEmpty()) {
            throw new IllegalArgumentException("List is empty.");
        }
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is error.");
        }
        return get(index, head).e;
    }
    private Node get(int index,Node node){
        if (node == null) {
            return node;
        }
        if (index == 0) {
            return node;
        }
        Node ret = get(index - 1, node.next);
        return ret;
    }
    //查询链表中的节点是否包含值e
    public boolean contains(E e){
        return contains(e, head);
    }
    private boolean contains(E e,Node node){
        if (node == null) {
            return false;
        }
        if (node.e == e) {
            return true;
        }
        return contains(e, node.next);
    }
    //重写Object类的toString方法:也是通过链表天然的递归性,来访问
    //链表的每一个节点
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Font -> ");
        linkToString(head, res);
        return res.toString();
    }
    private void linkToString(Node node,StringBuilder res){
        if (node == null) {
            res.append("NULL");
            return;
        }
        res.append(node.e + " -> ");
        linkToString(node.next, res);
        return;
    }
    
    /*public static void main(String[] args) {
        LinekedList<Integer> ll = new LinekedList<>();
        for (int i = 0; i < 13; i++) {
            ll.addLast(i);
            System.out.println(ll.toString());
        }
        System.out.println("------------------");
        for (int i = 0; i < 11; i++) {
            Integer ii = ll.removeFirst();
            System.out.println(ii);
            System.out.println(ll.toString());
        }
        
    }*/
}