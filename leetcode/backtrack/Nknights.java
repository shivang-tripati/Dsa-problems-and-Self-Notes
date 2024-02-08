package leetcode.backtrack;

public class Nknights {

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int ways_to_place =  knight(board, 0,0, 4);
        System.out.println(ways_to_place);

    }

    static int knight(boolean[][] board, int row, int col, int knights)  {
        if(knights == 0) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        if(row == board.length - 1 && col == board.length ) {
            return 0; // index out of bound just retrun;
        }
        

        if(col == board.length) {
            count += knight(board, row+1, 0, knights);
            return count;
        }

        if(isSafe(board, row, col)) { // if the place is safe just put is there
            board[row][col] =  true;
            count += knight(board, row, col+1, knights-1); //reduce the knights by 1
            board[row][col] =  false;
        }

        // if is not safe then just move ahead
        count += knight(board, row, col+1, knights); // knights will be same

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if(isValid(board, row-2, col-1)) { // check if the row, col are vaild coordinate, if
            if(board[row-2][col-1]){ // the check if there is knights avliable or not, if then
                return false; // return false
            }
        }
        if(isValid(board, row-2, col+1)) { // check if the row, col are vaild coordinate, if
            if(board[row-2][col+1]){ // the check if there is knights avliable or not, if then
                return false; // return false
            }
        }
        if(isValid(board, row-1, col-2)) { // check if the row, col are vaild coordinate, if
            if(board[row-1][col-2]){ // the check if there is knights avliable or not, if then
                return false; // return false
            }
        }
        if(isValid(board, row-1, col+2)) { // check if the row, col are vaild coordinate, if
            if(board[row-1][col+2]){ // the check if there is knights avliable or not, if then
                return false; // return false
            }
        }

        return true;
    }

    // do not repeat your self hence created this method
    static boolean isValid(boolean[][] board, int row, int col) {
        if(row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }

        return false;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row: board) {
            for(boolean element : row) {
                if(element) {
                    System.out.print(" K ");
                }else{
                    System.out.print(" X ");
                }
            }
            System.out.println();
        }
    }
}
