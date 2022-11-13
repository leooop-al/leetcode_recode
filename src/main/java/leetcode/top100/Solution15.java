package leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ziyou.cxf
 * @version : Solution15.java, v 0.1 2022年04月04日 16:17 ziyou.cxf Exp $
 */
public class Solution15 {

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        List<List<Integer>> lists = solution15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> target = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                // 当最小值大于0，则不可能
                return target;
            }
            // 过滤不重复的三元组
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (nums[j] + nums[k] > -nums[i] && k > j) {
                    k--;
                }
                if (k == j) {
                    break;
                }
                if (nums[j] + nums[k] == -nums[i]) {
                    target.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return target;
    }
}
