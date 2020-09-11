package com.array.easy.interview16_15;

/**
 * @author LiSheng
 * @date 2020/4/1 19:26
 */
public class Solution {
    public int[] masterMind(String solution, String guess) {
        int[] res = new int[2];
        int[] freq = new int[100];
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                res[0]++;
            } else {
                freq[solution.charAt(i)]++;
                sb2.append(guess.charAt(i));
            }
        }
        guess = sb2.toString();
        for (int i = 0; i < guess.length(); i++) {
            if (freq[guess.charAt(i)]-- > 0) {
                res[1]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().masterMind("GGBB", "RBYB");
    }
}
