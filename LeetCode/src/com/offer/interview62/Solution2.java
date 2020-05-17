package com.offer.interview62;

/**
 * @author LiSheng
 * @date 2020/5/15 20:17
 */
public class Solution2 {
    public int lastRemaining(int n, int m) {
        //最终剩下一个人，胜利者编号为0
        int p = 0;
        //反推，i表示剩余i个人
        for (int i = 2; i <= n; i++) {
            //f(n,m) = (f(n-1,m) + m) % n;
            p = (p + m) % i;
        }
        return p;
    }
}
