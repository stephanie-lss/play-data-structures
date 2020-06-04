package com.offer.interview31;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/6/4 10:19
 */
public class Solution3 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int idx = 0;
        for (int i = 0; i < pushed.length; i++) {
            while (!stack.isEmpty() && stack.getLast() == popped[idx]) {
                stack.removeLast();
                idx++;
            }
            if (pushed[i] != popped[idx]) {
                stack.addLast(pushed[i]);
            } else {
                idx++;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            for (int i = idx; i < popped.length; i++) {
                if (stack.getLast() != popped[i]) {
                    return false;
                }else {
                    stack.removeLast();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] ped = {2,1,0};
        int[] pop = {1,2,0};
        System.out.println(new Solution3().validateStackSequences(ped, pop));
    }
}
