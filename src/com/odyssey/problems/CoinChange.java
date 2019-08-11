package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.Arrays;

public class CoinChange implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int loc = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    loc = Math.min(loc, dp[i - coins[j]]);
                }
            }
            dp[i] = (loc == Integer.MAX_VALUE ? -1 : loc + 1);
        }
        return dp[amount];
    }
}
