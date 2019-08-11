package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.Arrays;

public class UniquePaths implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int uniquePaths(int m, int n) {
        if (m < 1 && n < 1) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
