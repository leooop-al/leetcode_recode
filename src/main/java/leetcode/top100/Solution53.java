package leetcode.top100;

import java.util.Stack;

/**
 * @author ziyou.cxf
 * @version : Solution53.java, v 0.1 2022年05月02日 15:11 ziyou.cxf Exp $
 */
public class Solution53 {

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        solution53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    public int maxSubArray(int[] nums) {
        int max = -100001;
        int add = 0;
        for (int num : nums) {
            add += num;
            max = Math.max(max, add);
            if (add < 0) {
                add = 0;
            }
        }
        return max;
    }
}
