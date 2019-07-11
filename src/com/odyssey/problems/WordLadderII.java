package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.*;

public class WordLadderII implements IProblem {

    private String beginWord;
    private String endWord;
    private List<String> wordList;

    @Override
    public void init() {
        beginWord = "hit";
        endWord = "cog";
        wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
    }

    @Override
    public void solve() {
        System.out.println(findLadders(beginWord, endWord, wordList));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> paths = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return paths;
        }
        Map<String, Set<String>> graph = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        dict.remove(beginWord);
        while (!q.isEmpty()) {
            boolean stop = false;
            int size = q.size();
            Set<String> removing = new HashSet<>();
            while (size-- > 0) {
                char[] cur = q.poll().toCharArray();
                String curWord = new String(cur);
                for (int i = 0; i < cur.length; i++) {
                    char t = cur[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        cur[i] = c;
                        String next = new String(cur);
                        if (dict.contains(next)) {
                            Set<String> neis = graph.computeIfAbsent(next, k -> (new HashSet<>()));
                            q.offer(next);
                            neis.add(curWord);
                            removing.add(next);
                            if (next.equals(endWord)) {
                                stop = true;
                            }
                        }
                    }
                    cur[i] = t;
                }
            }
            dict.removeAll(removing);
            if (stop) {
                break;
            }
        }
        getPaths(paths, new LinkedList<>(), graph, endWord);
        return paths;
    }

    private void getPaths(List<List<String>> paths, LinkedList<String> path, Map<String, Set<String>> graph, String cur) {
        Set<String> neis = graph.get(cur);
        if (neis == null) {
            LinkedList<String> onePath = new LinkedList<>(path);
            if (onePath.size() > 0) {
                onePath.addFirst(cur);
                paths.add(onePath);
            }
            return;
        }
        for (String next : neis) {
            path.addFirst(cur);
            getPaths(paths, path, graph, next);
            path.removeFirst();
        }
    }
}
