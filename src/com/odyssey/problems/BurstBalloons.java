package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class BurstBalloons implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                int loc = 0;
                int left = i > 0 ? nums[i - 1] : 1;
                int right = j < len - 1 ? nums[j + 1] : 1;
                for (int k = i; k <= j; k++) {
                    loc = Math.max(loc, (k == i ? 0 : dp[i][k - 1]) + (k == j ? 0 : dp[k + 1][j]) + nums[k] * left * right);
                }
                dp[i][j] = loc;
            }
        }
        return dp[0][len - 1];
    }
}
