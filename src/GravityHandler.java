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

    public static void main(String[] args) {
        /**
        GravityHandler g = new GravityHandler();
        int[][] newBoard = new int[7][6];
        newBoard = g.addPiece(newBoard, 0, 1);
        newBoard = g.addPiece(newBoard, 0, 2);
        newBoard = g.addPiece(newBoard, 4, 1);
        newBoard = g.addPiece(newBoard, 4, 2);
        newBoard = g.addPiece(newBoard, 4, 1);
        newBoard = g.addPiece(newBoard, 4, 2);

        for (int i = 0; i<7; i++) {
            System.out.print(newBoard[i][5]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(newBoard[i][4]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(newBoard[i][3]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(newBoard[i][2]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(newBoard[i][1]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(newBoard[i][0]);
        }

         */
    }

}
