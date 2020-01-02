/**
 * @author LiSheng
 * @date 2020/1/2 9:22
 * 思路：
 */
public class 链表法判断回文字符串 {
    private class ListNode {
        char val;
        ListNode next;

        ListNode(char x) {
            val = x;
        }

        ListNode(char[] arr) {
            if (arr == null || arr.length < 1) {
                throw new IllegalArgumentException("Illegal arr. Must input an array with data");
            }
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                res.append(cur.val + "->");
                cur = cur.next;
            }
            res.append("NULL");
            return res.toString();
        }
    }



    public boolean isCycString(String str) {
        if (str.isEmpty()) {
            return true;
        }
        ListNode head = new ListNode(str.toCharArray());
//        System.out.println(head);
        //定义快慢指针
        ListNode slow = head;
        ListNode fast = head;

        //偶数
        if (str.length() % 2 == 0) {
            while (fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode reverse = reverse(slow.next);
            fast = head;
            while (reverse != null) {
                if (reverse.val != fast.val) {
                    return false;
                }
                reverse = reverse.next;
                fast = fast.next;
            }
            return true;
        } else {
            //基数
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode reverse = reverse(slow);
            fast = head;
            while (fast != null){
                if(reverse.val != fast.val){
                    return false;
                }
                fast = fast.next;
                reverse = reverse.next;
            }
            return true;
        }
    }

    public ListNode reverse(ListNode head)//反转链表
    {
        ListNode newhead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newhead;
            newhead = head;
            head = next;
        }
        return newhead;


    }

    public static void main(String[] args) {
        链表法判断回文字符串 lb = new 链表法判断回文字符串();
        System.out.println(lb.isCycString("abccba"));
        System.out.println(lb.isCycString("abcba"));
        System.out.println(lb.isCycString("abdbba"));
        System.out.println(lb.isCycString("acvds"));
    }
}
