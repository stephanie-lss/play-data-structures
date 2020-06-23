package com.interview.solution1_3;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/6/23 11:01
 */
public class Solution {
    public String replaceSpaces(String S, int length) {
        char[] array = S.toCharArray();
        int count = 0;
        LinkedList<Integer> start = new LinkedList<>();
        for (int i = length - 1; i >= 0; i--) {
            if (S.charAt(i) == ' ') {
                count++;
                start.add(i);
            }
        }
        int end = length - 1 + 2 * count;
        for (int i = length - 1; count != 0 && i >= start.get(count - 1); i--) {
            array[i + 2 * count] = array[i];
            array[i] = ' ';
            if (i == start.getFirst()) {
                count--;
                start.removeFirst();
            }
        }
        while (count <= end) {
            if (array[count] == ' ') {
                array[count] = '%';
                array[count + 1] = '2';
                array[count + 2] = '0';
                count += 3;
            } else {
                count++;
            }
        }
        return String.valueOf(array).trim();
    }

    public static void main(String[] args) {
        String S = "ds sdfs afs sdfa dfssf asdf             ";
        System.out.println(new Solution().replaceSpaces(S, 27));
    }
}
