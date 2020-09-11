package com.offer.interview35;

/**
 * @author LiSheng
 * @date 2020/6/5 10:17
 */
public class Solution4 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node pre = head;
        while (pre != null) {
            Node cur = new Node(pre.val);
            cur.next = pre.next;
            pre.next = cur;
            pre = pre.next.next;
        }
        pre = head;
        System.out.println("复制节点的random指针还未分配：");
        while (pre != null) {
            if (pre.random == null) {
                System.out.println(pre.val + " " + -1);
            } else {
                System.out.println(pre.val + " " + pre.random.val);
            }
            pre = pre.next;
        }
        System.out.println("**");
        Node dup = head.next;
        pre = head;
        while (pre != null) {
            if (pre.random == null) {
                dup.random = null;
            } else {
                dup.random = pre.random.next;
            }
            pre = pre.next.next;
            if (dup.next != null) {
                dup = dup.next.next;
            }
        }
        System.out.println("复制节点的random指针已分配：");
        dup = head.next;
        while (dup != null) {
            if (dup.random == null) {
                System.out.println(dup.val + " " + -1);
            } else {
                System.out.println(dup.val + " " + dup.random.val);
            }
            dup = dup.next.next;
        }
        System.out.println("**");
        pre = head;
        dup = head.next;
        Node ret = head.next;
        while (pre != null) {
            pre.next = pre.next.next;
            pre = pre.next;
            if (dup.next != null) {
                dup.next = dup.next.next;
                dup = dup.next;
            }
        }
        System.out.println("复制的链表：");
        while (ret != null) {
            if (ret.random == null) {
                System.out.println(ret.val + " " + -1);
            } else {
                System.out.println(ret.val + " " + ret.random.val);
            }
            ret = ret.next;
        }
        return ret;
    }
}
