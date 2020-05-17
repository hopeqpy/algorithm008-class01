
/**
 * @program: algorithm
 * @description: 扫雷
 * @author: qpy
 */
public class Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        int rowLength = board.length;
        int columnLength = board[0].length;
        int clickRow = click[0];
        int clickColumn = click[1];
        if (board[clickRow][clickColumn] == 'M') {
            board[clickRow][clickColumn] = 'X';
        } else {
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int row = clickRow + i;
                    int column = clickColumn + j;
                    if (row < 0 || row >= rowLength || column < 0 || column >= columnLength) {
                        continue;
                    }
                    if (board[row][column] == 'M') {
                        count++;
                    }
                }
            }
            if (count > 0) {
                board[clickRow][clickColumn] = (char) (count + '0');
            } else {
                board[clickRow][clickColumn] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int row = clickRow + i;
                        int column = clickColumn + j;
                        if (row < 0 || row >= rowLength || column < 0 || column >= columnLength) {
                            continue;
                        }
                        if (board[row][column] == 'E') {
                            updateBoard( board, new int[]{row, column} );
                        }
                    }
                }
            }
        }
        return board;
    }
}
