package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution136.java, v 0.1 2022年07月17日 11:13 ziyou.cxf Exp $
 */
public class Solution136 {

    public static void main(String[] args) {
        Solution136 solution136 = new Solution136();
        System.out.println(solution136.singleNumber(new int[]{2, 2, 1}));
    }

    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

}
