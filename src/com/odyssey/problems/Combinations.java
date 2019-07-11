package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        if (n < k || k <= 0) {
            throw new IllegalArgumentException("n >= k > 0 required!");
        }
        ret.add(new ArrayList<>());
        for (int i = 0; i < k; i++) {
            int size = ret.size();
            while (size-- > 0) {
                List<Integer> cur = ret.poll();
                for (int j = cur.size() == 0 ? 1 : cur.get(cur.size() - 1) + 1; j <= n; j++) {
                    cur.add(j);
                    ret.offer(new ArrayList<>(cur));
                    cur.remove(cur.size() - 1);
                }
            }
        }
        return ret;
    }
}
