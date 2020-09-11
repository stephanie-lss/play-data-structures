package com.top100.solution394;

/**
 * @author LiSheng
 * @date 2020/5/2 17:21
 */
class Solution3 {

    int index = 0;

    public String decodeString(String s) {
        return dfs(s, 0);
    }

    private String dfs(String s, int i) {
        StringBuilder sb = new StringBuilder();
        int mut = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                mut = mut * 10 + (c - 48);
            } else if (c == '[') {
                String str = dfs(s, i + 1);
                while (mut-- != 0) {
                    sb.append(str);
                }
                mut = 0;
                i = index;
            } else if (c == ']') {
                index = i;
                return sb.toString();
            } else {
                sb.append(c);
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().decodeString("3[a]2[bc]"));
    }
}