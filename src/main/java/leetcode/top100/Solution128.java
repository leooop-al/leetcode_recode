package leetcode.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ziyou.cxf
 * @version : Solution128.java, v 0.1 2022年07月10日 11:25 ziyou.cxf Exp $
 */
public class Solution128 {

    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        System.out.println(solution128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int item : nums) {
            sets.add(item);
        }

        int maxStep = 1;
        for (int item : nums) {
            if (!sets.contains(item - 1)) {
                int step = 1;
                while (sets.contains(item + 1)) {
                    item = item + 1;
                    step += 1;
                }
                maxStep = Math.max(maxStep, step);
            }
        }
        return maxStep;
    }
}
