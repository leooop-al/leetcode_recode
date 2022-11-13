package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution31.java, v 0.1 2022年04月08日 18:54 ziyou.cxf Exp $
 */
public class Solution31 {

    public static void main(String[] args) {

    }

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        // 先找到第一个下降的点
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = nums[i];
    }

    private void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            swap(nums, begin, end);
            begin ++;
            end--;
        }
    }
}
