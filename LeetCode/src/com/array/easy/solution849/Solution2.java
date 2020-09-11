package com.array.easy.solution849;

/**
 * @author LiSheng
 * @date 2020/3/30 20:21
 */
class Solution2 {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int prev = -1, future = 0;
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                prev = i;
            } else {
                while (future < N && seats[future] == 0 || future < i) {
                    future++;
                }

                int left = prev == -1 ? N : i - prev;
                int right = future == N ? N : future - i;
                ans = Math.max(ans, Math.min(left, right));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] seats = {1, 0, 1, 0, 0, 0, 1, 0, 1};
        System.out.println(new Solution2().maxDistToClosest(seats));
    }
}
