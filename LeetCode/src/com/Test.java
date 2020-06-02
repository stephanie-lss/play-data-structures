package com;

/**
 * @author LiSheng
 * @date 2020/3/29 19:02
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        int[] nums = {1,2,3,4,5,6};
        ListNode head = new ListNode(nums);
        ListNode cur = head;
        cur = cur.next;
        ListNode newNode = new ListNode(-1);
        newNode.next = head.next.next;
        head.next.next = newNode;
        System.out.println(head.next == cur);
        System.out.println(head.next.equals(cur));
        System.out.println("head:"+head);
        System.out.println("cur:"+cur);
    }
}