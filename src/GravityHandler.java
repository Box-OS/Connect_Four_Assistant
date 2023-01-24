public class GravityHandler {

    public int[][] addPiece(int[][] board, int column, int player) {
        for (int i = 0; i<6; i++) {
            if (board[column][i] == 0) {
                board[column][i] = player;
                break;
            }
        }
        return board;
    }

    public static void main(String[] args) {}

}
