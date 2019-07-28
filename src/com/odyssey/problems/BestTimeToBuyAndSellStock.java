package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class BestTimeToBuyAndSellStock implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
