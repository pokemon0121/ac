package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.HashMap;
import java.util.Map;

public class CanIWin implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // check
        if (((1 + maxChoosableInteger) * maxChoosableInteger / 2) < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, 0, desiredTotal, 0, new HashMap<>());
    }

    private boolean dfs(int max, int pool, int goal, int cur, Map<Integer, Boolean> mem) {
        if (cur >= goal) {
            return true;
        }
        Boolean val = mem.get(pool);
        if (val != null) {
            return val;
        }
        for (int i = 1; i <= max; i++) {
            int mask = 1 << i;
            if ((mask & pool) == 0) {
                // this one I can pick
                if (cur + i >= goal) {
                    return true;
                }
                if (!dfs(max, pool | mask, goal, cur + i, mem)) {
                    mem.put(pool, true);
                    return true;
                }
            }
        }
        mem.put(pool, false);
        return false;
    }
}
