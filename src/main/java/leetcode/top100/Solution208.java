package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution208.java, v 0.1 2022年08月02日 21:13 ziyou.cxf Exp $
 */
public class Solution208 {

    public static void main(String[] args) {
        Solution208 solution208 = new Solution208();
        solution208.insert("apple");
        System.out.println(solution208.search("apple"));
        System.out.println(solution208.search("app"));
        System.out.println(solution208.startsWith("app"));
        solution208.insert("app");
        System.out.println(solution208.search("app"));
    }

    private Node root;

    public Solution208() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.childNodes[c - 'a'] == null) {
                cur.childNodes[c - 'a'] = new Node();
            }
            cur = cur.childNodes[c - 'a'];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.childNodes[c - 'a'] == null) {
                return false;
            }
            cur = cur.childNodes[c - 'a'];
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.childNodes[c - 'a'] == null) {
                return false;
            }
            cur = cur.childNodes[c - 'a'];
        }
        return true;
    }


    private class Node {
        private Node[] childNodes = new Node[26];

        private boolean end = false;
    }
}
