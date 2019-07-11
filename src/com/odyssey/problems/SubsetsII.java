package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ret, new ArrayList<>(), 0, nums);
        return ret;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int idx, int[] cans) {
        if (idx == cans.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        int len = cans.length;
        cur.add(cans[idx]);
        dfs(res, cur, idx + 1, cans);
        cur.remove(cur.size() - 1);
        int j = idx + 1;
        while (j < len && cans[j] == cans[idx]) {
            j++;
        }
        dfs(res, cur, j, cans);
    }
}
