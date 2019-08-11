package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class PredictTheWinner implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (j == i) {
                    dp[i][j] = nums[i];
                }
                else if (j == i + 1) {
                    dp[i][j] = Math.max(nums[i], nums[j]);
                }
                else {
                    dp[i][j] = Math.max(nums[i] + Math.min(dp[i + 1][j - 1], dp[i + 2][j]), nums[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
                }
            }
        }
        return dp[0][len - 1] >= sum - dp[0][len - 1];
    }
}
