package com.offer.interview33;

/**
 * @author LiSheng
 * @date 2020/6/4 11:12
 */
public class Solution3 {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int left, int right) {
        if (left > right) {
            return true;
        }
        int p = -1;
        for (int i = right - 1; i >= left; i--) {
            if (postorder[i] < postorder[right]) {
                p = i;
                break;
            }
        }
        for (int i = left; i < p; i++) {
            if (postorder[i] > postorder[right]) {
                return false;
            }
        }
        return helper(postorder, left, p) && helper(postorder, p + 1, right - 1);
    }
}
