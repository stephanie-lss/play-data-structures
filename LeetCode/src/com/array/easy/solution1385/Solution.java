package com.array.easy.solution1385;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/1 11:52
 */
public class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        List<Integer> list2 = new ArrayList<>(arr2.length);
        for (int i : arr2) {
            list2.add(i);
        }

        for (int i = 0; i < arr1.length; i++) {
            for (int j = -d; j <= d; j++) {
                if (list2.contains(arr1[i] + j)) {
                    break;
                }
                if (j == d){
                    count++;
                }
            }
        }
        return count;
    }
}
