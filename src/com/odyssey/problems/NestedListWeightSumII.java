package com.odyssey.problems;

import com.odyssey.datacontract.NestedInteger;
import com.odyssey.interfaces.IProblem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSumII implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        int sum = 0, curLevel = 0;
        Queue<NestedInteger> q = new LinkedList<>();
        for (NestedInteger ni : nestedList) {
            q.offer(ni);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                NestedInteger cur = q.poll();
                if (cur.isInteger()) {
                    curLevel += cur.getInteger();
                }
                else {
                    for (NestedInteger next : cur.getList()) {
                        q.offer(next);
                    }
                }
            }
            sum += curLevel;
        }
        return sum;
    }
}
