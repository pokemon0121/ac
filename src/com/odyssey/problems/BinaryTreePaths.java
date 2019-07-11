package com.odyssey.problems;

import com.odyssey.datacontract.TreeNode;
import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        List<String> fromLeft = binaryTreePaths(root.left);
        List<String> fromRight = binaryTreePaths(root.right);
        if (fromLeft.size() > 0) {
            for (String s : fromLeft) {
                ret.add(root.val + "->" + s);
            }
        }
        if (fromRight.size() > 0) {
            for (String s : fromRight) {
                ret.add(root.val + "->" + s);
            }
        }
        if (fromLeft.size() == 0 && fromRight.size() == 0) {
            ret.add(root.val + "");
        }
        return ret;
    }
}
