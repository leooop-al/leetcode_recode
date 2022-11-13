package leetcode.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ziyou.cxf
 * @version : Solution560.java, v 0.1 2022年08月21日 8:27 ziyou.cxf Exp $
 * @desc: dsf2是只需要一次的递归方式
 */
public class Solution560 {

    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        System.out.println(solution560.subarraySum(new int[]{-1,-1,1}, 0));
    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int preSum = 0;
        Map<Integer, Integer> maps = new HashMap<>();

        int count = 0;
        for (int i = 0; i <= n; i++) {
            preSum += nums[i];

            if (maps.containsKey(preSum - k)) {
                count += maps.get(preSum - k);
            }

            maps.put(preSum, maps.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
