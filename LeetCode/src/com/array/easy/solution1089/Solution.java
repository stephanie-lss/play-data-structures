package com.array.easy.solution1089;

/**
 * @author LiSheng
 * @date 2020/3/31 11:23
 */
public class Solution {
    //    public void duplicateZeros(int[] arr) {
//        for (int i = 0; i < arr.length - 1; ) {
//            if (arr[i] == 0) {
//                for (int j = arr.length - 1; j > i; j--) {
//                    arr[j] = arr[j - 1];
//                }
//                i += 2;
//            } else {
//                i++;
//            }
//        }
//    }
    public void duplicateZeros(int[] arr) {
        int count = 0;
        int len = arr.length;
        int i = 0;
        // 统计需要复制的0的个数，复制count个0，则会挤出原数组count个值
        // i进行扫描，遇到0则count自增
        // 若i+count大于原数组长度，则停止扫描，后面的直接舍弃
        while (i + count < len) {
            if (arr[i++] == 0) count++;
        }
        // 因为循环中i自增到了下一个值，此处i--返回到上一个结束值
        i--;
        int j = len - 1;
        // i从结束值开始，j从数组末尾开始，从后往前扫描，开始复制
        // 特别需要注意的是：若最后一个数字是0，统计需要复制的0时统计了该数，但若复制一次，则数组可能越界
        // 此处+1判断，如果越界，则只复制本身
        if (count + i + 1 > len) {
            arr[j--] = arr[i--];
            count--;
        }
        // 遇0则复制两次，非0则复制本身
        // count<=0时，说明前面没有0了，保持不变就行
        while (count > 0) {
            arr[j--] = arr[i];
            if (arr[i] == 0) {
                arr[j--] = arr[i];
                count--;
            }
            i--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0};
        new Solution().duplicateZeros(arr);
    }
}
