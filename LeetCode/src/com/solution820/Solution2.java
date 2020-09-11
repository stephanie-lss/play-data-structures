package com.solution820;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/28 12:22
 */
class Solution2 {
    public int minimumLengthEncoding(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());
        StringBuilder sb = new StringBuilder();
        int size = words[0].length() + 1;
        sb.append(words[0]);
        sb.append("#");
        for (int i = 1; i < words.length; i++) {
            if (sb.indexOf(words[i] + "#") < 0) {
                sb.append(words[i]);
                sb.append("#");
                size += words[i].length() + 1;
            }
        }
        return size;
    }

    public static void main(String[] args) {
    }
}
