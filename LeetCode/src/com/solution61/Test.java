package com.solution61;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/24 12:05
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ListNode head = new ListNode(nums);

        System.out.println(head);
        ListNode cur = head;
        cur.next =null;
        System.out.println(cur);
    }
}
