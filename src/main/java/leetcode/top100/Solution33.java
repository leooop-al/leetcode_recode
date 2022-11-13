package leetcode.top100;

import java.util.Arrays;

/**
 * @author ziyou.cxf
 * @version : Solution33.java, v 0.1 2022年04月10日 16:37 ziyou.cxf Exp $
 */
public class Solution33 {

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        System.out.println(solution33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 首先区分出，左段还是右段
            if (nums[mid] >= nums[lo]) {
                if (nums[lo] <= target && nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid +1;
                }
            } else{
                if (nums[hi] >= target && nums[mid] < target) {
                    lo = mid +1;
                } else {
                    hi = mid - 1;
                }
            }

        }
        return -1;
    }
}
