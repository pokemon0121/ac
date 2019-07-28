package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class LongestValidParentheses implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int longestValidParentheses(String s) {
        // use cur char and pre char
        if (s == null || s.length() < 2) {
            return 0;
        }
        int len = s.length();
        int max = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ')' && i > 0) {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
