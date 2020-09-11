package com.string.easy.solution937;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/4/5 19:54
 */
public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> apList = new ArrayList<>();
        List<String> numList = new ArrayList<>();
        for (String log : logs) {
            int index = log.indexOf(' ');
            if (!Character.isLetter(log.charAt(index + 1))) {
                numList.add(log);
            } else {
                apList.add(log);
            }
        }

        Collections.sort(apList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = o1.indexOf(' ');
                int j = o2.indexOf(' ');
                String o1Str = o1.substring(i);
                String o2Str = o2.substring(j);
                if (o1Str.compareTo(o2Str) > 0) {
                    return 1;
                } else if (o1Str.compareTo(o2Str) < 0) {
                    return -1;
                } else {
                    return o1.substring(0, i).compareTo(o2.substring(0, j));
                }
            }
        });
        int idx = 0;
        for (String s : apList) {
            logs[idx++] = s;
        }
        for (String s : numList) {
            logs[idx++] = s;
        }
        return logs;
    }

    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        System.out.println(new Solution().reorderLogFiles(logs));
    }
}
