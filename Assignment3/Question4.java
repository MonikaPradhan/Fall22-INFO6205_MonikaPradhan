package Assignment3;

//Question 4 : Word Search (https://leetcode.com/problems/word-search/)

public class Question4 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean result = exist(board,word);
        System.out.println("Word exists in the grid : "+result);
    }
    public static boolean exist(char[][] board, String word) {
        for(int i=0; i< board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(word.charAt(0) == board[i][j] && isWordPresent(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isWordPresent(char[][] board, String word, int row, int col, int position) {
        if(position == word.length()) {
            return true;
        }

        if(row< 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(position)) {
            return false;
        }

        board[row][col]='0';
        boolean result = isWordPresent(board, word, row+1, col, position+1) ||
                isWordPresent(board, word, row-1, col, position+1) ||
                isWordPresent(board, word, row, col+1, position+1) ||
                isWordPresent(board, word, row, col-1, position+1);
        board[row][col]=word.charAt(position);
        return result;
    }
}
