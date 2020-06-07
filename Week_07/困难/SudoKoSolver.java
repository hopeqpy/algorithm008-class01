package 困难;

/**
 * @program: algorithm
 * @description: 数独
 * @author: qpy
 */
public class SudoKoSolver {
    public void solveSD(char[][] board) {
        backtrack( board, 0, 0 );
    }

    boolean backtrack(char[][] board, int row, int col) {
        if (col == 9) {
            return backtrack( board, row + 1, 0 );
        }
        if (row == 9) {
            return true;
        }
        for (int i = row; i < 9; i++) {
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.') {
                    return backtrack( board, i, j + 1 );
                }
                for (char ch = '1'; ch <= '9'; ch++) {
                    if (!isValid( board, i, j, ch ))
                        continue;
                    board[i][j] = ch;
                    if (backtrack( board, i, j + 1 ))
                        return true;
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return false;
    }

    boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == n) {
                return false;
            }
            if (board[i][c] == n){
                return false;
            }
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n){
                return false;
            }

        }
        return true;
    }


}
