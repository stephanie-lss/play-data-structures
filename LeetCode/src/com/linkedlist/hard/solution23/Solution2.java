package com.linkedlist.hard.solution23;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/26 11:02
 */
class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.length - 1);
    }

    private ListNode mergeList(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = mergeList(lists, left, mid);
        ListNode l2 = mergeList(lists, mid + 1, right);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    /*
        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = null;
            ListNode pre = dummyHead;
            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    ListNode next = l2.next;
                    l2.next = null;
                    pre.next = l2;
                    l2 = next;
                } else {
                    ListNode next = l1.next;
                    l1.next = null;
                    pre.next = l1;
                    l1 = next;
                }
                pre = pre.next;
            }
            if (l1 != null) {
                pre.next = l1;
            }
            if (l2 != null) {
                pre.next = l2;
            }
            return dummyHead.next;
        }
    */
    public static void main(String[] args) {
        int[] arr1 = {-1, 1};
        int[] arr2 = {-3, 1, 4};
        int[] arr3 = {-2, -1, 0, 2};
        ListNode[] lists = {new ListNode(arr1), new ListNode(arr2), new ListNode(arr3)};
        System.out.println(new Solution2().mergeKLists(lists));
    }
}