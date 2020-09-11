package com.linkedlist.hard.solution23;

import com.ListNode;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/4/26 11:38
 */
class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        while (!pq.isEmpty()) {
            pre.next = pq.poll();
            pre = pre.next;
            if (pre.next != null) {
                pq.add(pre.next);
            }
        }
        return dummyHead.next;
    }
}