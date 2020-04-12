package com.linkedlist.easy.solution203;

/**
 * @author LiSheng
 * @date 2019/12/31 9:21
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        //哨兵节点
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null){
            if (pre.next.val == val){
                pre.next = pre.next.next;
            }else {
                pre = pre.next;
            }
        }
        return head;
    }
}
