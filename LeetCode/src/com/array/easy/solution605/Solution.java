package com.array.easy.solution605;

/**
 * @author LiSheng
 * @date 2020/3/29 21:53
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0) {
                if (i + 1 < flowerbed.length) {
                    if (flowerbed[i + 1] != 1 && flowerbed[i] != 1) {
                        flowerbed[i] = 1;
                        n--;
                        if (n == 0) {
                            return true;
                        }
                    }
                } else {
                    if (flowerbed[i] != 1) {
                        flowerbed[i] = 1;
                        n--;
                        if (n == 0) {
                            return true;
                        }
                    }
                }
                continue;
            }
            if (i == flowerbed.length - 1) {
                if (i - 1 >= 0) {
                    if (flowerbed[i - 1] != 1 && flowerbed[i] != 1) {
                        flowerbed[i] = 1;
                        n--;
                        if (n == 0) {
                            return true;
                        }
                    }
                } else {
                    if (flowerbed[i] != 1) {
                        flowerbed[i] = 1;
                        n--;
                        if (n == 0) {
                            return true;
                        }
                    }
                }
                continue;
            }
            if (flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1 && flowerbed[i] != 1) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int n = 1;
        System.out.println(new Solution().canPlaceFlowers(nums, n));
    }
}
