package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class BestTimeToBuyAndSellStockII implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
