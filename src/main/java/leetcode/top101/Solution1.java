package leetcode.top101;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ziyou.cxf
 * @version : Solution1.java, v 0.1 2022年08月27日 18:28 ziyou.cxf Exp $
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>(16);

        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(nums[i])) {
                ans[0] = maps.get(nums[i]);
                ans[1] = i;
                return ans;
            }
            maps.put(target - nums[i], i);
        }
        return null;
    }
}
