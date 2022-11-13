package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution581.java, v 0.1 2022年08月22日 23:07 ziyou.cxf Exp $
 */
public class Solution581 {

    public static void main(String[] args) {
        Solution581 solution581 = new Solution581();
        System.out.println(solution581.findUnsortedSubarray(new int[]{1,3,2,2,2}));
    }

    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                break;
            }
        }

        if (i == nums.length) {
            return 0;
        }

        int j = nums.length - 1;

        for (; j > 0; j--) {
            if (nums[j - 1] > nums[j]) {
                break;
            }
        }

        int a = 0;
        int b = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > nums[i] && k < i) {
                a = k;
                break;
            }
        }
        for (int k = nums.length - 1; k >= 0; k--) {
            if (nums[k] > nums[j] && k > j) {
                b = k;
                break;
            }
        }
        return b - a + 2 ;
    }
}
