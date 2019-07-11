package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.*;

public class Subsets implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> q = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return q;
        }
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        q.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = q.size();
            while (size-- > 0) {
                List<Integer> cur = q.poll();
                for (int j = cur.size() == 0 ? 0 : numToIndex.get(cur.get(cur.size() - 1)) + 1; j < nums.length; j++) {
                    cur.add(nums[j]);
                    q.offer(new ArrayList<>(cur));
                    ret.add(new ArrayList<>(cur));
                    cur.remove(cur.size() - 1);
                }
            }
        }
        return ret;
    }
}
