public class BoardHandler {

    /**
     * checks if there are 4 same-player pieces in a row and gives a true-or-false return
     *
     * @param board the game board in a 2D array
     * @param userOrder the user the method checks for a win
     * @return true if 4 pieces are in a row in any orientation
     */
    public boolean checkForWin(int[][] board, int userOrder) {
        // check for horizontal win
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                int lineScore = rateLine(board[i][j], board[i][j + 1], board[i][j + 2], board[i][j + 3], userOrder);
                if (lineScore >= 1000 || lineScore <= -1000) {
                    return true;
                }
            }
        }

        // check for vertical win
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                int lineScore = rateLine(board[i][j], board[i + 1][j], board[i + 2][j], board[i + 3][j], userOrder);
                if (lineScore >= 1000 || lineScore <= -1000) {
                    return true;
                }
            }
        }

        // check for diagonal win (top left to bottom right)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                int lineScore = rateLine(board[i][j], board[i + 1][j + 1], board[i + 2][j + 2], board[i + 3][j + 3], userOrder);
                if (lineScore >= 1000 || lineScore <= -1000) {
                    return true;
                }
            }
        }

        // check for diagonal win (top right to bottom left)
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                int lineScore = rateLine(board[i][j], board[i + 1][j - 1], board[i + 2][j - 2], board[i + 3][j - 3], userOrder);
                if (lineScore >= 1000 || lineScore <= -1000) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * evaluates and gives a total score for the entire board situation
     *
     * @param board the game board in a 2D array
     * @param userOrder userOrder the user the method checks for a win
     * @return a total board score based on rateLine's output of each set of 4 adjacent spots
     */
    public int evalBoard(int[][] board, int userOrder) {
        int score = 0;
        // check for horizontal lines
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                score += rateLine(board[i][j], board[i][j + 1], board[i][j + 2], board[i][j + 3], userOrder);
            }
        }
        // check for vertical lines
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                score += rateLine(board[i][j], board[i + 1][j], board[i + 2][j], board[i + 3][j], userOrder);
            }
        }
        // check for diagonal lines (left to right)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                score += rateLine(board[i][j], board[i + 1][j + 1], board[i + 2][j + 2], board[i + 3][j + 3], userOrder);
            }
        }
        // check for diagonal lines (right to left)
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                score += rateLine(board[i][j], board[i + 1][j - 1], board[i + 2][j - 2], board[i + 3][j - 3], userOrder);
            }
        }
        return score;
    }

    /**
     * Rates a group of 4 pieces and assigns a score based on amount of pieces in a row
     *
     * @param a first piece in row
     * @param b second piece in row
     * @param c third piece in row
     * @param d fourth piece in row
     * @param userOrder order in which user started, where 1 is first and 2 is second
     * @return a score based on amount of user and opponent pieces in a row
     */
    public int rateLine(int a, int b, int c, int d, int userOrder) {
        int opponentOrder = (userOrder == 1) ? 2 : 1;

        //puts input values into an array
        int[] line = new int[] {a, b, c, d};

        //initializes rating value with 0
        int lineRating = 0;

        //creates variables for pieces in a row for each party
        int userCount;
        int opponentCount;

        userCount = pieceCounter(line, userOrder);
        opponentCount = pieceCounter(line, opponentOrder);

        // check if user has winning line
        if (userCount == 4 && opponentCount == 0) {
            lineRating += 1000;
        } else if (userCount == 3 && opponentCount == 0) {
            lineRating += 100;
        } else if (userCount == 2 && opponentCount == 0) {
            lineRating += 10;
        }

        // check if user has a line with 3 pieces and a filled spot
        else if (userCount == 3 && opponentCount == 1) {
            lineRating += 50;
        }

        // check if opponent has winning line
        if (opponentCount == 4 && userCount == 0) {
            lineRating -= 1000;
        } else if (opponentCount == 3 && userCount == 0) {
            lineRating -= 100;
        } else if (opponentCount == 2 && userCount == 0) {
            lineRating -= 10;
        }
        // check if opponent has a line with 3 pieces and a filled spot
        else if (opponentCount == 3 && userCount == 1) {
            lineRating -= 50;
        }
        // if a line consists of 2 user spots and 2 opponent spots, the ranking is neutral, 0.

        return lineRating;
    }

    /**
     * pieceCounter counts a player's pieces in a row for any given 4 adjacent pieces.
     *
     * @param line an array of 4 adjacent pieces in any orientation specified by rateLine
     * @param player indicates if method should check for player 1 or player 2's pieces
     * @return the amount of pieces that are in a row
     */
    public int pieceCounter(int[] line, int player) {
        int i;
        int inRow = 0;
        for (int j = 0; j<line.length; j++) {
            i = 1;
            boolean flag = line[j] == player;
            while(flag && i + j <= line.length) {
                try {
                    flag = line[j] == line[j+i];
                } catch (ArrayIndexOutOfBoundsException ignored) {}
                i++;
            }

            inRow = i-1;

            if (inRow>1) {
                break;
            }
        }
       return inRow;
    }


    public static void main(String[] args) {}
}
