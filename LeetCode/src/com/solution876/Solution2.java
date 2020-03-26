package com.solution876;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/3/23 14:45
 */
public class Solution2 {
    public ListNode middleNode(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null && low != null) {
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode node = new ListNode(arr);
        System.out.println(new Solution2().middleNode(node));
    }
}
