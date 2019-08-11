package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class PaintHouseII implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        int n = costs.length, k = costs[0].length;
        int[] a = costs[0];
        int[] b = new int[k];
        for (int i = 1; i < n; i++) {
            int loc = Integer.MAX_VALUE;
            for (int x = 0; x < k; x++) {
                for (int j = 0; j < k; j++) {
                    if (x == j) {
                        continue;
                    }
                    loc = Math.min(loc, a[j]);
                }
                b[x] = loc + costs[i][x];
                if (i == n - 1) {
                    minCost = Math.min(minCost, b[x]);
                }
            }
            int[] t = a;
            a = b;
            b = t;
        }
        if (minCost == Integer.MAX_VALUE) {
            for (int cost : costs[0]) {
                minCost = Math.min(minCost, cost);
            }
        }
        //return minCost;
    }
}
