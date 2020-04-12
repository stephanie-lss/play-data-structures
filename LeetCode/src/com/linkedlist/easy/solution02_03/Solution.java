package com.linkedlist.easy.solution02_03;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/6 13:54
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        int[] node = {1, 2, 3, 4, 5, 6};
        new Solution().deleteNode(new ListNode(node));
    }
}
