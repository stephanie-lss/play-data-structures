package com.linkedlist.easy.solution83;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/20 12:43
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4};
        System.out.println(new Solution().deleteDuplicates(new ListNode(nums)));
    }
}
