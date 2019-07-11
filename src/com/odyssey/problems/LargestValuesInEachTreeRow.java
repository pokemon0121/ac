package com.odyssey.problems;

import com.odyssey.datacontract.TreeNode;
import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValuesInEachTreeRow implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        if (root == null) {
            return vals;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                // new level begins
                TreeNode cur = q.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            vals.add(max);
        }
        return vals;
    }
}
