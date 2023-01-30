public class GravityHandler {

    BoardArrayHandler copier = new BoardArrayHandler();

    public boolean isValidMove(int[][] board, int column) {
        return board[0][column] == 0;
    }

    public int[][] addPiece(int[][] board, int column, int player) {
        int[][] newBoard = copier.deepCopy(board);

        // iterate from the bottom to the top of the board
        for (int row = board.length - 1; row >= 0; row--) {
            // check if the current slot is empty
            if (board[row][column] == 0) {
                // place the player's piece in the slot
                newBoard[row][column] = player;
                break;
            }
        }
        return newBoard;
    }

    public int findLowest(int[][] board, int column) {
        int lowestSlot = 0;
        for (int i = 5; i>=0; i--) {
            if (board[i][column] == 0) {
                lowestSlot = i;
                break;
            }
        }
        return lowestSlot;
    }
}
