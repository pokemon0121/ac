package com.odyssey.problems;

import com.odyssey.datacontract.TreeNode;
import com.odyssey.interfaces.IProblem;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftmost = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean goingDeeper = false;
            // record first element of this level
            leftmost = q.peek().val;
            while (size-- > 0) {
                // new level begins
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    goingDeeper = true;
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    goingDeeper = true;
                    q.offer(cur.right);
                }
            }
            if (!goingDeeper) {
                return leftmost;
            }
        }
        return leftmost;
    }
}
