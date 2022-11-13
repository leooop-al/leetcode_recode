package leetcode.top100;

import java.util.Arrays;

/**
 * @author ziyou.cxf
 * @version : Trie.java, v 0.1 2022年04月26日 16:11 ziyou.cxf Exp $
 */
public class Trie {

    private TrieNode root = new TrieNode('/');

    public void insert(String word) {
        TrieNode p = root;
        for (char a : word.toCharArray()) {
            int index = a - 'a';
            if (null == p.childNodes[index]) {
                p.childNodes[index] = new TrieNode(a);
            }
            p = p.childNodes[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(String word) {
        TrieNode p = root;
        for (char a : word.toCharArray()) {
            int index = a - 'a';
            if (null == p.childNodes[index]) {
                return false;
            }
            p = p.childNodes[index];
        }
        return p.isEndingChar;
    }

    class TrieNode {

        private char data;

        private TrieNode[] childNodes = new TrieNode[26];

        private boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
