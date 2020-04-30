package com.linkedlist.hard.solution23;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/26 9:11
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = null;
        ListNode pre = dummyHead;
        while (true) {
            int count = 0;
            ListNode dHead = new ListNode(Integer.MIN_VALUE);
            dHead.next = null;
            ListNode tmpCur = dHead;
            boolean flag = false;
            for (ListNode node : lists) {
                if (node != null) {
                    flag = true;
                    lists[count] = node.next;
                    node.next = null;
                    if (tmpCur.val > node.val) {
                        ListNode tmpPre = dHead;
                        while (tmpPre.next != null) {
                            if (tmpPre.next.val < node.val) {
                                tmpPre = tmpPre.next;
                            } else {
                                node.next = tmpPre.next;
                                tmpPre.next = node;
                                break;
                            }
                        }
                    } else {
                        tmpCur.next = node;
                        tmpCur = tmpCur.next;
                    }
                }
                count++;
            }
            if (!flag) {
                break;
            }
            if (pre.val <= dHead.next.val) {
                pre.next = dHead.next;
            } else {
                //合并两个有序链表
                ListNode t1 = dummyHead;
                ListNode t2 = dHead.next;
                while (t1.next != null && t2 != null) {
                    if (t1.next.val < t2.val) {
                        t1 = t1.next;
                    } else {
                        ListNode next = t2.next;
                        t2.next = t1.next;
                        t1.next = t2;
                        t2 = next;
                    }
                }
                if (t1.next == null) {
                    t1.next = t2;
                }
            }
            while (pre.next != null) {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {-1, 1};
        int[] arr2 = {-3, 1, 4};
        int[] arr3 = {-2, -1, 0, 2};
        ListNode[] lists = {new ListNode(arr1), new ListNode(arr2), new ListNode(arr3)};
        System.out.println(new Solution().mergeKLists(lists));
    }
}