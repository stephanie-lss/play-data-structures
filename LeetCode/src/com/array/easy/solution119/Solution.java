package com.array.easy.solution119;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/27 21:57
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int count = 1;
            if (i == 0) {
                res.add(list);
                continue;
            }
            while (count != i) {
                list.add(res.get(i - 1).get(count - 1) + res.get(i - 1).get(count));
                count++;
            }
            list.add(1);
            res.add(list);
        }
        return res.get(rowIndex);
    }

    public static void main(String[] args) {
        List<Integer> list = new Solution().getRow(3);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }
}