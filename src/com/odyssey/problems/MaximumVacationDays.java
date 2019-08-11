package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class MaximumVacationDays implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int maxVacationDays(int[][] flights, int[][] days) {
        if (flights == null || flights.length == 0 || flights[0] == null || flights[0].length == 0 || days == null || days.length == 0 || days[0] == null || days[0].length == 0) {
            return 0;
        }
        int K = days[0].length;
        int N = flights.length;
        int[][] dp = new int[K][N];
        int max = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (k == j || flights[k][j] == 1) {
                        dp[i][j] = Math.max(dp[i][j], (i == 0 ? (j == 0 || flights[0][j] == 1 ? 0 : Integer.MIN_VALUE) : dp[i - 1][k]) + days[j][i]);
                    }
                }
                if (i == K - 1) {
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
