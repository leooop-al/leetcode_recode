package leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ziyou.cxf
 * @version : Solution56.java, v 0.1 2022年05月25日 19:41 ziyou.cxf Exp $
 */
public class Solution56 {

    public static void main(String[] args) {
        int[][] intervals = {{2,3}, {4,5},{6,7}, {8,9}, {1,10}};
        int[][] merge = new Solution56().merge(intervals);
        System.out.println(Arrays.toString(merge));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<List<Integer>> result = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (right < intervals[i][0]) {
                result.add(Arrays.asList(left, right));
                left = intervals[i][0];
                right = intervals[i][1];
            } else {
                left = Math.min(left, intervals[i][0]);
                right = Math.max(right, intervals[i][1]);
            }
        }

        if (result.size() == 0 || result.get(result.size() - 1).get(1) != right) {
            result.add(Arrays.asList(left, right));
        }

        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i).get(0);
            ans[i][1] = result.get(i).get(1);
        }
        return ans;
    }
}
