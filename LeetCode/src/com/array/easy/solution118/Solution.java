package com.array.easy.solution118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/27 20:50
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int count = 1;
            if (i == 0){
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
        return res;
    }

    public static void main(String[] args) {
        new Solution().generate(5);
    }
}