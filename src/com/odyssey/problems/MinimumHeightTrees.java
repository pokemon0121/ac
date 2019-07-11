package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.*;

public class MinimumHeightTrees implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> oneNode = new ArrayList<>();
            oneNode.add(0);
            return oneNode;
        }
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int[] edge : edges) {
            nodes[edge[0]].addNei(edge[1]);
            nodes[edge[1]].addNei(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int nodeNum = n;
        for (int i = 0; i < n; i++) {
            if (nodes[i].isLeaf()) {
                q.offer(i);
                nodeNum--;
            }
        }
        while (nodeNum > 0) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                for (int nei : nodes[cur].neis) {
                    nodes[nei].removeNei(cur);
                    if (nodes[nei].isLeaf()) {
                        q.offer(nei);
                        nodeNum--;
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }

    private class Node {
        public Set<Integer> neis;
        public int label;

        public void addNei(int nei) {
            neis.add(nei);
        }

        public void removeNei(int nei) {
            neis.remove(nei);
        }

        public boolean isLeaf() {
            return neis.size() == 1;
        }

        public Node(int label) {
            this.label = label;
            neis = new HashSet<>();
        }
    }
}
