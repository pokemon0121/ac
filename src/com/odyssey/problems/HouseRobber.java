package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class HouseRobber implements IProblem {
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
        int pp = nums[0];
        int p = Math.max(nums[0], nums[1]);
        int cur = 0;
        for (int i = 2; i < nums.length; i++) {
            cur = Math.max(pp + nums[i], p);
            pp = p;
            p = cur;
        }
        return cur;
    }
}
