package leetcode.top100;

import java.util.Arrays;

/**
 * @author ziyou.cxf
 * @version : Solution75.java, v 0.1 2022年06月14日 17:19 ziyou.cxf Exp $
 */
public class Solution75 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};

        Solution75 solution75 = new Solution75();
        solution75.sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int prt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, prt);
                prt++;
            }
        }
        for (int i = prt; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, prt);
                prt++;
            }
        }
    }

    private void swap(int[] nums, int i , int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }
}
