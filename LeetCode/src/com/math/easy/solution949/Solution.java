package com.math.easy.solution949;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/12 16:06
 */
public class Solution {
    public String largestTimeFromDigits(int[] A) {
        StringBuilder sb = new StringBuilder();
        List<Integer> aList = new ArrayList<>();
        for (int i : A) {
            aList.add(i);
        }
        aList.sort((o1, o2) -> o2 - o1);
        if (aList.get(0) >= 6 && aList.get(1) >= 6) {
            if (aList.get(3) >= 2) {
                return "";
            }
            if (aList.get(2) > 1) {
                if (aList.get(3) <= 1) {
                    sb.append(aList.get(3));
                    aList.remove(3);
                } else {
                    return "";
                }
            } else {
                sb.append(aList.get(2));
                aList.remove(2);
            }
            sb.append(aList.get(0));
            aList.remove(0);
            sb.append(":");
            if (aList.get(1) <= 5) {
                sb.append(aList.get(1));
                sb.append(aList.get(0));
            } else {
                return "";
            }
        } else {
            for (int i = 0; i < aList.size(); i++) {
                if (aList.get(i) <= 2) {
                    sb.append(aList.get(i));
                    aList.remove(i);
                    break;
                }
                if (i == aList.size() - 1) {
                    return "";
                }
            }
            for (int i = 0; i < aList.size(); i++) {
                if (sb.charAt(0) == '1' || sb.charAt(0) == '0') {
                    sb.append(aList.get(i));
                    aList.remove(i);
                    break;
                } else {
                    if (aList.get(i) <= 3) {
                        sb.append(aList.get(i));
                        aList.remove(i);
                        break;
                    }
                }
                if (i == aList.size() - 1) {
                    return "";
                }
            }
            sb.append(":");
            for (int i = 0; i < aList.size(); i++) {
                if (aList.get(i) <= 5) {
                    sb.append(aList.get(i));
                    aList.remove(i);
                    break;
                }
                if (i == aList.size() - 1) {
                    return "";
                }
            }
            sb.append(aList.get(0));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] A = {2, 6, 6, 6};
        System.out.println(new Solution().largestTimeFromDigits(A));
    }
}
