package com.linkedlist.easy.solution203;

/**
 * @author LiSheng
 * @date 2019/12/31 10:47
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next,val);
        return (head.val == val ? head.next : head);
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = (new Solution3()).removeElements(head, 6);
        System.out.println(res);
    }
}