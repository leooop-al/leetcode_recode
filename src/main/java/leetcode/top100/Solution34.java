package leetcode.top100;

import java.util.Arrays;

/**
 * @author ziyou.cxf
 * @version : Solution34.java, v 0.1 2022年04月10日 17:34 ziyou.cxf Exp $
 */
public class Solution34 {

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        System.out.println(Arrays.toString(solution34.searchRange(new int[]{5, 7, 7, 8, 10}, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while ((lo <= hi)) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                int a = mid - 1;
                while (a >= 0 && nums[a] == target) {
                    a--;
                }
                int b = mid + 1;
                while (b <= nums.length - 1 && nums[b] == target) {
                    b++;
                }
                return new int[]{a+1, b-1};
            }
        }
        return new int[]{-1, -1};
    }
}
