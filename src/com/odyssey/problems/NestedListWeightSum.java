package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;
import com.odyssey.datacontract.NestedInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        int sum = 0;
        Queue<NestedInteger> q = new LinkedList<>();
        for (NestedInteger ni : nestedList) {
            q.offer(ni);
        }
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                NestedInteger cur = q.poll();
                if (cur.isInteger()) {
                    sum += cur.getInteger() * level;
                }
                else {
                    for (NestedInteger next : cur.getList()) {
                        q.offer(next);
                    }
                }
            }
            level++;
        }
        return sum;
    }
}
