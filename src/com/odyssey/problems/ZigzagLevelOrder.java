package com.odyssey.problems;

import com.odyssey.datacontract.TreeNode;
import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder implements IProblem {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> elements = new ArrayList<>();
        if (root == null) {
            return elements;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (leftToRight) {
                    level.addLast(cur.val);
                }
                else {
                    level.addFirst(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            leftToRight = !leftToRight;
            elements.add(level);
        }
        return elements;
    }

    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }
}
