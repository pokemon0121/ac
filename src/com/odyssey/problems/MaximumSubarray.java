package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class MaximumSubarray implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], loc = nums[0];
        for (int i = 1; i < nums.length; i++) {
            loc = Math.max(loc + nums[i], nums[i]);
            max = Math.max(max, loc);
        }
        return max;
    }
}
