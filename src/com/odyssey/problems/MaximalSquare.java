package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class MaximalSquare implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col];
        for (int i = 0; i < row; i++) {
            int leftUp = 0;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    int loc = Math.min(Math.min(dp[j], j == 0 ? 0 : dp[j - 1]), leftUp) + 1;
                    leftUp = i == 0 ? 0 : dp[j];
                    dp[j] = loc;
                    max = Math.max(max, dp[j]);
                }
                else {
                    dp[j] = 0;
                }
            }
        }
        return max * max;
    }
}
