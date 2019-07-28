package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class PalindromePartitioningII implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int minCut(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        boolean[][] isP = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i] = i;
            for (int j = i; j >= 0; j--) {
                if (j == i || (s.charAt(j) == s.charAt(i) && (j + 1 == i || isP[j + 1][i - 1]))) {
                    dp[i] = Math.min(dp[i], j == 0 ? 0 : (dp[j - 1] + 1));
                    isP[j][i] = true;
                }
            }
        }
        return dp[len - 1];
    }
}
