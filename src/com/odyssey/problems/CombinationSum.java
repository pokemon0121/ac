package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret, new ArrayList<>(), 0, candidates, 0, target);
        return ret;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int idx, int[] cans, int curSum, int target) {
        if (curSum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        int len = cans.length;
        if (idx >= len || curSum > target) {
            return;
        }
        for (int i = idx; i < len; i++) {
            curSum += cans[i];
            cur.add(cans[i]);
            dfs(res, cur, i, cans, curSum, target);
            cur.remove(cur.size() - 1);
            curSum -= cans[i];
        }
    }
}
