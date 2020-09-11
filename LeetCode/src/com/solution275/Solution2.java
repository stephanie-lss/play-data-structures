package com.solution275;

/**
 * @author LiSheng
 * @date 2020/4/29 21:22
 */
class Solution2 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //n - mid 为论文数=h指数，mid越大，h指数越小，所需要满足
            //如果h指数比论文中被引用最少的论文引用数要大，这篇论文不符合要求，需要去掉，
            //因此h指数过高，需要降低，也就是减小论文的数目
            if (n - mid > citations[mid]) {
                left = mid + 1;
                //此时表示h指数暂时时是符合条件的，继续寻找是否能满足更高的h指数
            } else if (n - mid < citations[mid]) {
                right = mid;
                //此时表示h指数暂时时是符合条件的，继续寻找是否能满足更高的h指数
            } else if (n - mid == citations[mid]) {
                right = mid;
            }
        }
        //返回值：h指数
        return n - left;
    }

    public static void main(String[] args) {
        int[] cit = {0, 1, 2, 5, 6};
        System.out.println(new Solution2().hIndex(cit));
    }
}
