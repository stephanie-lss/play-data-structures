package com.solution23;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/7/30 9:22
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = 0;
        if (lists == null || (n = lists.length) == 0) {
            return null;
        }
        return mergeList(lists, 0, n - 1);
    }

    private ListNode mergeList(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode list1 = mergeList(lists, left, mid);
        ListNode list2 = mergeList(lists, mid + 1, right);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummyHead.next;
    }
}