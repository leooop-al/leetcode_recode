package leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziyou.cxf
 * @version : Solution207.java, v 0.1 2022年08月02日 20:07 ziyou.cxf Exp $
 */
public class Solution207 {

    private List<List<Integer>> edges;

    private int[] visited;

    private boolean valid = true;

    public static void main(String[] args) {
        Solution207 solution207 = new Solution207();
        System.out.println(solution207.canFinish(2, new int[][]{{1, 0}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>(numCourses);
        visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
            visited[i] = 0;
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            edges.get(b).add(a);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                isValid(i);
                if (!valid) {
                    return false;
                }
            }
        }
        return true;
    }

    private void isValid(int edge) {
        visited[edge]  = 1;
        for (int w : edges.get(edge)) {
            if (visited[w] == 0) {
                isValid(w);
                if (!valid) {
                    return;
                }
            } else if (visited[w] == 1){
                valid = false;
                return;
            }
        }
        visited[edge] = 2;
    }
}
