package leetcode.top100;

/**
 * @author ziyou.cxf
 * @version : Solution79.java, v 0.1 2022年06月25日 15:21 ziyou.cxf Exp $
 */
public class Solution79 {

    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        boolean abcced = solution79.exist(new char[][]{{'A', 'B', 'C', 'E' }, {'S', 'F', 'E', 'S' }, {'A', 'D', 'E', 'E' }},
                "ABCESEEEFS");
        System.out.println(abcced);
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean data = deepSearch(board, i, j, 0, word, new boolean[board.length][board[i].length]);
                if (data) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean deepSearch(char[][] board, int i, int j, int step, String word, boolean[][] mark) {
        if (step == word.length()) {
            return true;
        }

        if (step >= word.length() || i >= board.length || i < 0 || j >= board[i].length  || j < 0 || mark[i][j]) {
            return false;
        }


        if (board[i][j] != word.charAt(step)) {
            return false;
        }

        mark[i][j] = true;

        if (deepSearch(board, i, j + 1, step + 1, word, mark) ||
                deepSearch(board, i, j - 1, step + 1, word, mark) ||
                deepSearch(board, i + 1, j, step + 1, word, mark) ||
                deepSearch(board, i - 1, j, step + 1, word, mark)){
            return true;
        }

        mark[i][j] = false;
        return false;
    }
}
