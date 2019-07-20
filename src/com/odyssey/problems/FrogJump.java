package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.*;

public class FrogJump implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public boolean canCross(int[] stones) {
        Set<Integer> set = new HashSet<>();
        for (int stone : stones) {
            set.add(stone);
        }
        return canCross(stones, 0, 0, set, new HashMap<>());
    }

    private boolean canCross(int[] s, int cur, int k, Set<Integer> set, Map<Integer, Map<Integer, Boolean>> mem) {
        if (cur == s[s.length - 1]) {
            return true;
        }
        Boolean val = mem.getOrDefault(cur, new HashMap<>()).get(k);
        if (val != null) {
            return val;
        }
        for (int i = -1; i <= 1; i++) {
            int nextStep = i + k;
            if (nextStep <= 0) {
                continue;
            }
            if (set.contains(cur + nextStep) && canCross(s, cur + nextStep, nextStep, set, mem)) {
                mem.putIfAbsent(cur, new HashMap<>());
                mem.get(cur).put(k, true);
                return true;
            }
        }
        mem.putIfAbsent(cur, new HashMap<>());
        mem.get(cur).put(k, false);
        return false;
    }
}
