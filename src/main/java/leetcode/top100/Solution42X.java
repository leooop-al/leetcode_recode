package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution42X.java, v 0.1 2022年05月01日 16:58 ziyou.cxf Exp $
 */
public class Solution42X {


    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            if (height[l] < height[r]) {
                ans += leftMax - height[l];
                l++;
            } else {
                ans += rightMax - height[r];
                r--;
            }
        }
        return ans;
    }
}
