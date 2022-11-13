package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution42.java, v 0.1 2022年04月22日 15:44 ziyou.cxf Exp $
 */
public class Solution42 {

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        solution42.trap(height);
    }

    public int trap(int[] height) {
        int result = 0;

        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (height[left] < height[right]) {
                result += (leftMax - height[left]);
                left++;
            } else {
                result += (rightMax - height[right]);
                right++;
            }
        }

        return result;
    }
}
