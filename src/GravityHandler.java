public class GravityHandler {

    public boolean isValidMove(int[][] board, int column) {
        return board[0][column] == 0;
    }

    public int[][] addPiece(int[][] board, int column, int player) {
        for (int i = 5; i>=0; i--) {
            if (board[i][column] == 0) {
                board[i][column] = player;
                break;
            }
        }
        return board;
    }

    public static void main(String[] args) {}

}
