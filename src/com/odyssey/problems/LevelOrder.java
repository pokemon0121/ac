package com.odyssey.problems;

import com.odyssey.datacontract.TreeNode;
import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder implements IProblem {

    private TreeNode root;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> elements = new ArrayList<>();
        if (root == null) {
            return elements;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            elements.add(level);
        }
        return elements;
    }

    @Override
    public void solve() {
        System.out.println(levelOrder(root));
    }

    @Override
    public void init() {
        root = new TreeNode(0);
    }
}
