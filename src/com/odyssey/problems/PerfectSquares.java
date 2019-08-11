package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class PerfectSquares implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int numSquares(int n) {
        if (n < 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int j = 1;
            int loc = Integer.MAX_VALUE;
            while (i - j * j >= 0) {
                loc = Math.min(loc, dp[i - j * j]);
                j++;
            }
            dp[i] = loc + 1;
        }
        return dp[n];
    }
}
