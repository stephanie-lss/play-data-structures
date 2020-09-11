package com.offer.interview33;

/**
 * @author LiSheng
 * @date 2020/5/19 15:33
 */
class Solution2 {
    public boolean verifyPostorder(int[] postorder) {
        return leftRightRoot(postorder, 0, postorder.length - 1);
    }

    private boolean leftRightRoot(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }

        int p = left;
        while (postorder[p] < postorder[right]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[right]) {
            p++;
        }

        return p == right && leftRightRoot(postorder, left, m - 1) && leftRightRoot(postorder, m, right - 1);
    }

    //[0,rightIdx - 1]
    //[rightIdx,rootIdx-1]
    //[rootIdx]

    public static void main(String[] args) {
        int[] nums = {4,6,7,5};
        System.out.println(new Solution2().verifyPostorder(nums));
    }
}