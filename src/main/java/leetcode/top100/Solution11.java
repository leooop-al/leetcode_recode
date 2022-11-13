package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution11.java, v 0.1 2022年04月04日 15:59 ziyou.cxf Exp $
 */
public class Solution11 {

    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length -1;

        int maxArea = 0;
        while (lo < hi) {
            maxArea = Math.max(maxArea, (hi - lo) * Math.min(height[lo], height[hi]));
            if (height[lo] <= height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int i = solution11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }
}
