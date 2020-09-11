package com.array.easy.solution941;

/**
 * @author LiSheng
 * @date 2020/3/28 13:54
 */
public class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        //上山
        int i = 0;
        for (i = 0; i < A.length - 1; i++) {
            //山顶
            if (A[i + 1] < A[i]) {
                break;
            }
            //有相等的 或 没有下山的过程
            if (A[i+1] == A[i] || i == A.length - 2){
                return false;
            }
        }
        //没有上山的过程
        if (i == 0){
            return false;
        }
        //下山
        for (int j = i; j < A.length - 1; j++) {
            //有相等的
            if (A[j + 1] >= A[j]) {
                return false;
            }
        }
        return true;
    }
}
