package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution35.java, v 0.1 2022年04月12日 15:41 ziyou.cxf Exp $
 */
public class Solution35 {

    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }
}
