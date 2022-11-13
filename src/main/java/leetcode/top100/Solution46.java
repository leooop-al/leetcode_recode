package leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziyou.cxf
 * @version : Solution46.java, v 0.1 2022年05月01日 17:08 ziyou.cxf Exp $
 */
public class Solution46 {

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        List<List<Integer>> permute = solution46.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] mark= new boolean[nums.length];
        deep(result, new ArrayList<>(), nums, mark);
        return result;
    }

    private void deep(List<List<Integer>> result, List<Integer> ans, int[] nums, boolean[] mark) {
        if (nums.length == ans.size()) {
            result.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (mark[i]) {
                continue;
            }
            mark[i] = true;
            ans.add(nums[i]);
            deep(result, ans, nums, mark);
            ans.remove(ans.size() - 1);
            mark[i] = false;
        }
    }
}
