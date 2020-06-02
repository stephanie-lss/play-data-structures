package com.offer.interview17;

/**
 * @author LiSheng
 * @date 2020/5/11 21:14
 */
public class Solution3 {
    public void printNumbers(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        while (!increment(sb)) {
            int idx = 0;
            while (sb.charAt(idx) == '0'){
                idx++;
            }
            System.out.println(sb.substring(idx));
        }
    }

    private boolean increment(StringBuilder sb) {
        boolean isOver = false;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = (char) (sb.charAt(i) + 1);
            if (c > '9') {
                sb.replace(i, i + 1, "0");
                if (i == 0) {
                    isOver = true;
                }
            } else {
                sb.replace(i, i + 1, String.valueOf(c));
                break;
            }
        }
        return isOver;
    }


    public static void main(String[] args) {
        new Solution3().printNumbers(3);
    }
}