package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution152.java, v 0.1 2022年07月25日 21:36 ziyou.cxf Exp $
 */
public class Solution152 {

    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        System.out.println(solution152.maxProduct(new int[]{2, -5, -2, -4, 3}));
    }

    public int maxProduct(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int[] maxF = new int[nums.length];
        int[] minF = new int[nums.length];
        System.arraycopy(nums, 0, maxF, 0, nums.length);
        System.arraycopy(nums, 0, minF, 0, nums.length);
        for (int i = 1; i < nums.length; i++) {
            maxF[i] = Math.max(nums[i] * maxF[i - 1], Math.max(nums[i], nums[i] * minF[i - 1]));
            minF[i] = Math.min(nums[i] * minF[i - 1], Math.min(nums[i], nums[i] * maxF[i - 1]));
        }
        int ans = maxF[0];
        for (int i = 1; i < nums.length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }

        return ans;
    }
}
