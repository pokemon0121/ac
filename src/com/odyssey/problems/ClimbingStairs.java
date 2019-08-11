package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class ClimbingStairs implements IProblem {

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int p = 2, pp = 1, cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = p + pp;
            pp = p;
            p = cur;
        }
        return cur;
    }

    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }
}
