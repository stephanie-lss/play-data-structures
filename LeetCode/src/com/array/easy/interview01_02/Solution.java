package com.array.easy.interview01_02;

/**
 * @author LiSheng
 * @date 2020/4/1 14:43
 */
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            freq[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "krqdpwdvgfuogtobtyylexrebrwzynzlpkotoqmokfpqeibbhzdjcwpgprzpqersmmdxdmwssfbfwmmvrxkjyjteirloxpbiopso";
        String s2 = "pyymgxtdqzqxxkmirptmbewjobpslwkbmmzfbwzmltowevsofkydrejdpcoripjlewoqzgusvypotrdkepbqspxdmoyrfnyrbrof";
        System.out.println(s1.length());
        System.out.println(s2.length());
        System.out.println(new Solution().CheckPermutation(s1, s2));
    }
}
