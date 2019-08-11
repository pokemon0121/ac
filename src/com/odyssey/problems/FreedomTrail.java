package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class FreedomTrail implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int findRotateSteps(String ring, String key) {
        if (ring == null || ring.length() == 0 || key == null || key.length() == 0) {
            return 0;
        }
        int lenR = ring.length();
        int lenK = key.length();
        int[][] dp = new int[lenK][lenR];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lenK; i++) {
            for (int j = 0; j < lenR; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (key.charAt(i) == ring.charAt(j)) {
                    if (i == 0) {
                        dp[i][j] = getDistance(0, j, lenR);
                    }
                    else {
                        for (int k = 0; k < lenR; k++) {
                            if (dp[i - 1][k] != Integer.MAX_VALUE) {
                                dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + getDistance(k, j, lenR));
                            }
                        }
                    }
                }
                if (i == lenK - 1) {
                    min = Math.min(min, dp[i][j]);
                }
            }
        }
        return min + lenK;
    }

    private int getDistance(int from, int to, int lenR) {
        return Math.min((to - from + lenR) % lenR, (from - to + lenR) & lenR);
    }
}
