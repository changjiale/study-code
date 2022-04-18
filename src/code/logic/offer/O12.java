package code.logic.offer;

import java.util.Arrays;

/**
 * 矩阵路径
 */
public class O12 {

    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, char[] word, int i, int j, int idx) {

        //边界条件
        if (idx == word.length) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word[idx]) {
            return false;
        }

        //标记不走回头路
        board[i][j] = '\0';

        int nextIdx = idx + 1;
        //上下左右各走一次
        boolean exit = dfs(board, word, i-1, j, nextIdx) ||
                dfs(board, word, i, j+1, nextIdx) ||
                dfs(board, word, i+1, j, nextIdx) ||
                dfs(board, word, i, j-1, nextIdx);

        board[i][j] = word[idx];

        return exit;
    }

    public static void main(String[] args) {
        char[][] board = {{'b','e','c'},{'a','c','b'},{'d','e','f'}};
        /**
         * b e c
         * a c b
         * d e f
         */
        String word = "bec";
        boolean exit = exist(board, word);
        System.out.println(exit);

    }
}
