public class BoardHandler extends GravityHandler{

    ;

    //int indicating the user's pieces
    private final int USER = 1;
    //int indicating the opponent's pieces
    private final int OPPONENT = 2;

    private int[][] player1Board = {
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0}
    };

    private int[][] player2Board = {
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0}
    };

    public int lowestRow(int column) {
        return findLowest(player1Board, column);
    }

    public void placePiece(int column, int player) {
        player1Board = addPiece(player1Board, column, player);
        player2Board = addPiece(player2Board, column, player==1?2:1);
    }

    public int nextMove(int boardSelection) {
        int[][] tempBoard;
        if (boardSelection == 2) {
            tempBoard = player2Board;
        } else {
            tempBoard = player1Board;
        }
        return findBestMove(tempBoard);
    }

    public void dump() {
        for (int i = 0; i<7; i++) {
            System.out.print(player1Board[0][i]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(player1Board[1][i]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(player1Board[2][i]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(player1Board[3][i]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(player1Board[4][i]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(player1Board[5][i]);
        }
        System.out.println("");
        System.out.println("");

        for (int i = 0; i<7; i++) {
            System.out.print(player2Board[0][i]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(player2Board[1][i]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(player2Board[2][i]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(player2Board[3][i]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(player2Board[4][i]);
        }
        System.out.println("");
        for (int i = 0; i<7; i++) {
            System.out.print(player2Board[5][i]);
        }
        System.out.println("");
        System.out.println("");
    }

    /**
     * Iterates through placing a piece in each column and calling upon evalBoard() to rate the position
     *
     * @param board the game board being passed in
     * @return the column for the best move
     */
    private int findBestMove(int[][] board) {


        // Initialize best move as an invalid move
        int bestMove = -1;
        // Initialize best score as the lowest possible value
        int bestScore = Integer.MIN_VALUE;

        // Loop through all possible moves
        for (int i = 0; i < 7; i++) {
            // Check if the move is valid
            if (isValidMove(board, i)) {
                int[][] newBoard;
                // Make the move and get the new board state
                newBoard = addPiece(board, i, USER);
                //if move is winning, break and output move
                if (checkForWin(newBoard)) {
                    bestMove = i;
                    break;
                }
                //checks score of board
                int score = evalBoard(newBoard);
                // If score of position is better than previous, update
                if ( score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }


        }
        return bestMove;
    }


    private int findBestMoveRecur(int[][] board, int depth, boolean isMaximizing) {
        // Initialize best move as an invalid move
        int bestMove = -1;
        // Initialize best score based on player
        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        // Loop through all possible moves
        for (int i = 0; i < 7; i++) {
            // Check if the move is valid
            if (isValidMove(board, i)) {
                // Make the move and get the new board state
                int[][] newBoard = addPiece(board, i, isMaximizing ? USER : OPPONENT);
                // Recursively call minimax with the new board state, remaining depth, and opposite player
                int score = minimax(newBoard, depth - 1, !isMaximizing);
                // If the current player is the maximizing player, updates the best score and move if necessary
                if (isMaximizing && score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
                // If the current player is the minimizing player
                else if (!isMaximizing && score < bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }
        return bestMove;
    }



    /**
     * minimax
     *
     * @param board the board passed into the method
     * @param depth indicates the maximum depth algorithm is to recurse
     * @param isMaximizing determines which player we are helping
     * @return an int representing the score of the position
     */
    private int minimax(int[][] board, int depth, boolean isMaximizing) {
        // Check if the game is over by calling checkForWin()
        if (checkForWin(board)) {
            // If the current player is the maximizing player, return a score of 10 to indicate a win
            if (isMaximizing) {
                return 10000000;
            }
            // If the current player is the minimizing player, return a score of -10 to indicate a loss
            else {
                return -10000000;
            }
        }

        // If the depth is 0 or the board is full, return the evaluation of the current board state
        if (depth == 0) {
            return evalBoard(board);
        }

        // If the current player is the maximizing player
        int bestScore;
        if (isMaximizing) {
            // Initialize the best score to the lowest possible value
            bestScore = Integer.MIN_VALUE;
            // Loop through all possible moves
            for (int i = 0; i < 7; i++) {
                // Check if the move is valid
                if (isValidMove(board, i)) {
                    // Make the move and get the new board state
                    int[][] newBoard = addPiece(board, i, USER);
                    // Recursively call minimax with the new board state, remaining depth, and minimizing player
                    int score = minimax(newBoard, depth - 1, false);
                    // Update the best score if necessary
                    bestScore = Math.max(score, bestScore);
                }
            }
        }
        // If the current player is the minimizing player
        else {
            // Initialize the best score to the highest possible value
            bestScore = Integer.MAX_VALUE;
            // Loop through all possible moves
            for (int i = 0; i < 7; i++) {
                // Check if the move is valid
                if (isValidMove(board, i)) {
                    // Make the move and get the new board state
                    int[][] newBoard = addPiece(board, i, 2);
                    // Recursively call minimax with the new board state, remaining depth, and maximizing player
                    int score = minimax(newBoard, depth - 1, true);
                    // Update the best score if necessary
                    bestScore = Math.min(score, bestScore);
                }
            }
        }
        return bestScore;
    }
    /**
     * checks if there are 4 same-player pieces in a row and gives a true-or-false return
     *
     * @param board the game board in a 2D array
     * @return true if 4 pieces are in a row in any orientation
     */
    private boolean checkForWin(int[][] board) {
        // check for horizontal win
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                boolean flag = board[i][j] == USER && board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2] && board[i][j + 2] == board[i][j + 3];
                if (flag) {
                    return true;
                }
            }
        }

        // check for vertical win
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                boolean flag = board[i][j] == USER && board[i][j] == board[i + 1][j] && board[i + 1][j] == board[i + 2][j] && board[i + 2][j] == board[i + 3][j];
                if (flag) {
                    return true;
                }
            }
        }

        // check for diagonal win (top left to bottom right)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                boolean flag = board[i][j] == USER && board[i][j] == board[i + 1][j + 1] && board[i + 1][j + 1] == board[i + 2][j + 2] && board[i + 2][j + 2] == board[i + 3][j + 3];
                if (flag) {
                    return true;
                }
            }
        }

        // check for diagonal win (top right to bottom left)
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                boolean flag = board[i][j] == USER && board[i][j] == board[i + 1][j - 1] && board[i + 1][j - 1] == board[i + 2][j - 2] && board[i + 2][j - 2] == board[i + 3][j - 3];
                if (flag) {
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
     * @return a total board score based on rateLine's output of each set of 4 adjacent spots
     */
    private int evalBoard(int[][] board) {
        int boardScore = 0;
        // check for horizontal lines
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                int tempScore = rateLine(board[i][j], board[i][j + 1], board[i][j + 2], board[i][j + 3]);
                if (tempScore > boardScore) {
                    boardScore = tempScore;
                }
            }
        }
        // check for vertical lines
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                int tempScore = rateLine(board[i][j], board[i + 1][j], board[i + 2][j], board[i + 3][j]);
                if (tempScore > boardScore) {
                    boardScore = tempScore;
                }
            }
        }
        // check for diagonal lines (left to right)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                int tempScore = rateLine(board[i][j], board[i + 1][j + 1], board[i + 2][j + 2], board[i + 3][j + 3]);
                if (tempScore > boardScore) {
                    boardScore = tempScore;
                }
            }
        }
        // check for diagonal lines (right to left)
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                int tempScore = rateLine(board[i][j], board[i + 1][j - 1], board[i + 2][j - 2], board[i + 3][j - 3]);
                if (tempScore > boardScore) {
                    boardScore = tempScore;
                }
            }
        }
        return boardScore;
    }

    /**
     * Rates a group of 4 pieces and assigns a score based on amount of pieces in a row
     *
     * @param a first piece in row
     * @param b second piece in row
     * @param c third piece in row
     * @param d fourth piece in row
     * @return a score based on amount of user and opponent pieces in a row
     */
    private int rateLine(int a, int b, int c, int d) {

        //puts input values into an array
        int[] line = new int[] {a, b, c, d};

        //initializes rating value with 0
        int lineRating = 0;

        //creates variables for pieces in a row for each party
        int userCount;
        int opponentCount;

        userCount = pieceCounter(line, USER);
        opponentCount = pieceCounter(line, OPPONENT);

        // check if user has winning line
        if (userCount == 4 && opponentCount == 0) {
            lineRating += 1000;
        } else if (userCount == 3 && opponentCount == 0) {
            lineRating += 100;
        } else if (userCount == 2 && opponentCount == 0) {
            lineRating += 10;
        } else if (userCount == 1 && opponentCount == 0) {
            lineRating +=5;
        }

        // check if user has a line with 3 pieces and a filled spot
        else if (userCount == 3 && opponentCount == 1) {
            lineRating += 50;
        } else if (userCount == 2 && opponentCount == 1) {
            lineRating += 25;
        }

        // check if opponent has winning line
        if (opponentCount == 4 && userCount == 0) {
            lineRating -= 1000;
        } else if (opponentCount == 3 && userCount == 0) {
            lineRating -= 100;
        } else if (opponentCount == 2 && userCount == 0) {
            lineRating -= 10;
        } else if (opponentCount == 1 && userCount == 0) {
            lineRating -=5;
        }

        // check if opponent has a line with 3 pieces and a filled spot
        else if (opponentCount == 3 && userCount == 1) {
            lineRating -= 50;
        } else if (opponentCount == 2 && userCount == 1) {
            lineRating -= 25;
        }
        // if a line consists of 2 user spots and 2 opponent spots, the ranking is neutral, 0.

        return lineRating;
    }

    /**
     * pieceCounter counts a player's pieces in a row for any given 4 adjacent pieces.
     *
     * @param line an array of 4 adjacent pieces in any orientation specified by rateLine
     * @param player indicates if method should check for player 1 (user) or player 2 (opponent)'s pieces
     * @return the amount of pieces that are in a row
     */
    private int pieceCounter(int[] line, int player) {
        // Initialize the number of pieces in a row as 0
        int inRow = 0;
        for (int j = 0; j < line.length; j++) {
            int i = 1;
            // Check if the current piece belongs to the specified player
            boolean flag = line[j] == player;
            // Iterate through the remaining pieces in the line
            while (flag && i + j <= line.length) {
                try {
                    // Check if the next piece belongs to the specified player
                    flag = line[j] == line[j + i];
                } catch (ArrayIndexOutOfBoundsException ignored) {}
                i++;
            }
            // Update the number of pieces in a row
            inRow = i - 1;
            if (inRow > 1) {
                break; // If there are more than one consecutive pieces belonging to the specified player, break the loop
            }
        }
        return inRow;
    }

    public static void main(String[] args) {
        BoardHandler b = new BoardHandler();
        int[][] board = {
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0}
        };
    }
}
