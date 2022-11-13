package leetcode.top101;

/**
 * @author ziyou.cxf
 * @version : Solution4.java, v 0.1 2022年08月28日 10:57 ziyou.cxf Exp $
 * @desc : 寻找两个正序数组的中位数
 */
public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        solution4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }

    // 4 / 6 = 10
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int allLen = nums1.length + nums2.length;
        int k1 = (allLen) / 2;
        int k2 = k1;
        if (allLen % 2 == 0) {
            k2 = k1 - 1;
        }
        return mergeFindArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k1) +
                mergeFindArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k2);
    }


    private int mergeFindArrays(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) {
            return mergeFindArrays(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return mergeFindArrays(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return mergeFindArrays(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
