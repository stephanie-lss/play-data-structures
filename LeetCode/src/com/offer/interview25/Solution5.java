package com.offer.interview25;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/3 15:59
 */
public class Solution5 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = null;
        ListNode pre = dummyHead;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    pre.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    pre.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                pre = pre.next;
            } else if (l1 != null) {
                pre.next = l1;
                break;
            } else if (l2 != null) {
                pre.next = l2;
                break;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4};
        ListNode head1 = new ListNode(nums1);
        int[] nums2 = {1, 3, 4};
        ListNode head2 = new ListNode(nums2);
        System.out.println(new Solution5().mergeTwoLists(head1, head2));
    }
}
