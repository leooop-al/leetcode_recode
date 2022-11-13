package leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziyou.cxf
 * @version : Solution78.java, v 0.1 2022年06月22日 22:32 ziyou.cxf Exp $
 */
public class Solution78 {

    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        solution78.subsets(new int[]{1, 2, 3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int subSize = ans.size();
            for (int j = 0; j < subSize; j++) {
                List<Integer> subList = new ArrayList<>(ans.get(j));
                subList.add(num);
                ans.add(subList);
            }
        }
        return ans;
    }
}
