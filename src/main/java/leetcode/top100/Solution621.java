package leetcode.top100;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ziyou.cxf
 * @version : Solution621.java, v 0.1 2022年08月23日 21:06 ziyou.cxf Exp $
 */
public class Solution621 {

    public static void main(String[] args) {
        Solution621 solution621 = new Solution621();
        solution621.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B', }, 2);
    }

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] array = new int[26];
        for (char task : tasks) {
            array[task - 'A']++;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.count - o1.count;
            }
        });

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                pq.add(new Node((char) ('A' + i), array[i]));
            }
        }

        int ans = 0;
        List<Node> tmp = new ArrayList<>();
        do {
            if (pq.isEmpty()) {
                pq.addAll(tmp);
                tmp.clear();
                if (ans % (n + 1) != 0) {
                    ans = (1 + ans / (n + 1)) * (n+1);
                }
            } else {
                if (ans % (n + 1) == 0) {
                    pq.addAll(tmp);
                    tmp.clear();
                }
                Node node = pq.poll();
                node.count--;
                if (node.count > 0) {
                    tmp.add(node);
                }
                ans++;
            }
        } while (!pq.isEmpty() || !tmp.isEmpty());

        return n;
    }

    private class Node {
        private char c;

        private int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
