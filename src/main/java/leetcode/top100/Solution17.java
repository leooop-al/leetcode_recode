package leetcode.top100;

import java.util.*;

/**
 * @author ziyou.cxf
 * @version : Solution17.java, v 0.1 2022年04月04日 17:54 ziyou.cxf Exp $
 */
public class Solution17 {

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.letterCombinations("4"));
    }


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> maps = new HashMap<>(16);
        maps.put('2', "abc");
        maps.put('3', "def");
        maps.put('4', "ghi");
        maps.put('5', "jkl");
        maps.put('6', "mno");
        maps.put('7', "pqrs");
        maps.put('8', "tuv");
        maps.put('9', "wxyz");

        List<String> target = new ArrayList<>();
        target.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> tmp = new ArrayList<>();
            String s = maps.get(digits.charAt(i));
            for (int j = 0; j < target.size(); j++) {
                for (int k = 0; k < s.length(); k++) {
                    tmp.add(target.get(j) + s.charAt(k));
                }
            }
            target = tmp;
        }
        return target;
    }

}
