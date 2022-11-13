package leetcode.top100;

import java.util.*;

/**
 * @author ziyou.cxf
 * @version : Solution49.java, v 0.1 2022年05月02日 14:49 ziyou.cxf Exp $
 */
public class Solution49 {

    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        solution49.groupAnagrams(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> result = new HashMap<>(16);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(str);
        }
        result.forEach((k,v) -> ans.add(v));
        return ans;
    }
}
