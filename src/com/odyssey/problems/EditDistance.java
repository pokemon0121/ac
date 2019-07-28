package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class EditDistance implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int len1 = word1.length(), len2 = word2.length();
        int[] dp = new int[len2 + 1];
        for (int i = 1; i <= len2; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            int leftUp = i - 1;
            dp[0] = i;
            for (int j = 1; j <= len2; j++) {
                int loc = 0;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    loc = leftUp;
                }
                else {
                    loc = Math.min(Math.min(dp[j - 1], dp[j]), leftUp) + 1;
                }
                leftUp = dp[j];
                dp[j] = loc;
            }
        }
        return dp[len2];
    }
}
