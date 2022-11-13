 package leetcode.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ziyou.cxf
 * @version : Solution36.java, v 0.1 2022年04月12日 15:51 ziyou.cxf Exp $
 */
public class Solution36 {

    public static void main(String[] args) {
        char a = '1';
        char b = '1';

        char[][] board = new char[][]{{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }

    public static  boolean isValidSudoku(char[][] board) {
        int[][] boardsC = new int[9][9];
        int[][] boardsR = new int[9][9];
        int[][] subBoards = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int index = board[i][j] - '1';
                boardsC[i][index] ++;
                boardsR[j][index] ++;

                int subIndex = (3*i+j)/3;
                subBoards[subIndex][index]++;
                if (boardsC[i][index] > 0 || boardsR[j][index] > 0 || subBoards[subIndex][index] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
