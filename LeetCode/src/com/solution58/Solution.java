package com.solution58;

/**
 * @author LiSheng
 * @date 2020/2/23 11:13
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.isEmpty()){
            return 0;
        }
        String[] str = s.split(" ");
        System.out.println("str:"+str.length);
        if (str.length-1>=0){
            return str[str.length-1].length();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("   "));
    }

}
