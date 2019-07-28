package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.List;

public class Triangle implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int min = Integer.MAX_VALUE;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int leftUp = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                int loc = triangle.get(i).get(j) + (i == j && i > 0 ? leftUp : Math.min(dp[j], leftUp));
                leftUp = dp[j];
                dp[j] = loc;
                if (i == n - 1) {
                    min = Math.min(min, dp[j]);
                }
            }
        }
        return min;
    }
}
