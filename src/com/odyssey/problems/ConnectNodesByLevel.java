package com.odyssey.problems;

import com.odyssey.datacontract.Node;
import com.odyssey.datacontract.TreeNode;
import com.odyssey.interfaces.IProblem;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesByLevel implements IProblem {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            while (size-- > 0) {
                Node cur = queue.poll();
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }

    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }
}
