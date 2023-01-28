public class GravityHandler {

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
