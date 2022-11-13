package leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ziyou.cxf
 * @version : Solution39.java, v 0.1 2022年04月22日 15:13 ziyou.cxf Exp $
 */
public class Solution39 {

    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        List<List<Integer>> lists = solution39.combinationSum(new int[]{2, 3,5}, 8);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        deepSearch(result, new ArrayList<>(), 0, candidates, target);
        return result;
    }

    private void deepSearch(List<List<Integer>> result, List<Integer> cur, int index, int[] candidates, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >=0) {
                cur.add(candidates[i]);
                deepSearch(result, cur, i, candidates, target - candidates[i]);
                cur.remove(cur.size() - 1);
            }

        }
    }
}
