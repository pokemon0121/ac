package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class HouseRobberII implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 3) {
            return Math.max(nums[0], nums.length == 1 ? 0 : nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(nums[1], Math.max(nums[0], nums[1]));
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int pp = nums[start];
        int p = Math.max(nums[start], nums[start + 1]);
        int cur = 0;
        for (int i = start + 2; i <= end; i++) {
            cur = Math.max(pp + nums[i], p);
            pp = p;
            p = cur;
        }
        return cur;
    }
}
