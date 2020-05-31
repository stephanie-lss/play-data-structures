package com.offer.interview06;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/5/30 14:20
 */
public class Solution2 {
    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[0];
        }
        ListNode pre = null;
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            size++;
        }
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = pre.val;
            pre = pre.next;
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 2};
        ListNode head = new ListNode(nums);
        int[] ints = new Solution2().reversePrint(head);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}
