package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution312.java, v 0.1 2022年08月13日 17:45 ziyou.cxf Exp $
 * @desc : 太难了
 */
public class Solution312 {

    public static void main(String[] args) {
        Solution312 solution312 = new Solution312();
        System.out.println(solution312.maxCoins(new int[]{3, 1, 5, 8}));
    }

    public int maxCoins(int[] _nums) {
        int[] nums = new int[_nums.length+2];
        for (int i = 1; i <= _nums.length; i++) {
            nums[i] = _nums[i - 1];
        }
        nums[0] = 1;
        nums[_nums.length + 1] = 1;

        int[][] store = new int[nums.length][nums.length];
        for (int n = 2; n < nums.length; n++) {
            for (int i = 0; i < nums.length - n; i++) {
                rangeBest(i, i + n, store, nums);
            }
        }
        return store[0][nums.length - 1];
    }

    private void rangeBest(int i, int j, int[][] store, int[] nums) {
        int max = 0;
        for (int k = i+1; k < j; k++) {
            int left = store[i][k];
            int right = store[k][j];

            int a = left + right + nums[i] * nums[k] * nums[j];
            max = Math.max(a, max);
        }
        store[i][j] = max;
    }
}
