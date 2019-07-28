package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class BestTimeToBuyAndSellStockIII implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }
}
