package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class MinimumPathSum implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[] dp = new int[col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else {
                    dp[j] = grid[i][j] + Math.min(i > 0 ? dp[j] : Integer.MAX_VALUE, j > 0 ? dp[j - 1] : Integer.MAX_VALUE);
                }
            }
        }
        return dp[col - 1];
    }
}
