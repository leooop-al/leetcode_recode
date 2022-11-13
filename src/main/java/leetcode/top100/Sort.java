package leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ziyou.cxf
 * @version : Sort.java, v 0.1 2022年08月06日 13:20 ziyou.cxf Exp $
 */
public class Sort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] data = new int[]{3, 1, 2, 5, 4, 12312, 31, 233, 21};
        quickSort.quickSort(data);
        System.out.println(Arrays.toString(data));
    }

    private static class QuickSort {

        public void quickSort(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
        }

        private void quickSort(int[] nums, int lo, int hi) {
            if (lo >= hi) {
                return;
            }
            int partition = partition(nums, lo, hi);
            quickSort(nums, lo, partition - 1);
            quickSort(nums, partition + 1, hi);
        }

        private int partition(int[] nums, int lo, int hi) {
            int point = lo;
            int v = nums[lo];
            lo += 1;
            while (true) {
                while (lo <= hi && v > nums[lo]) {
                    lo++;
                }
                while (lo <= hi && v < nums[hi]) {
                    hi--;
                }
                if (lo >= hi) {
                    break;
                }
                swam(nums, lo, hi);
            }
            swam(nums, point, hi);
            return hi;
        }
    }

    public static void swam(int[] nums, int i, int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }
}
