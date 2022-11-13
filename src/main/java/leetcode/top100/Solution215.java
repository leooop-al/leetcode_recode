package leetcode.top100;

import java.util.Arrays;

/**
 * @author ziyou.cxf
 * @version : Solution215.java, v 0.1 2022年08月05日 8:49 ziyou.cxf Exp $
 */
public class Solution215 {

    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        System.out.println(solution215.findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5));
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int a, int b, int k) {
        if (a >= b) {
            return;
        }
        int partition = partition(nums, a, b);
        if (partition == k) {
            return;
        }
        if (partition < k) {
            quickSort(nums, partition + 1, b, k);
        } else {
            quickSort(nums, a, partition - 1, k);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int a = lo + 1;
        int b = hi;
        int v = nums[lo];
        while (true) {
            while (a <= b && nums[a] < v) {
                a++;
            }
            while (a <= b && nums[b] >= v) {
                b--;
            }
            if (a > b) {
                break;
            }
            swap(nums, a, b);
        }
        swap(nums, lo, b);

        return b;
    }

    private void swap(int[] nums, int a, int b) {
        int v = nums[a];
        nums[a] = nums[b];
        nums[b] = v;
    }
}
