public class BoardHandler {

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

        int[] line = new int[] {a, b, c, d};

        int lineRating = 0;

        int userCount;
        int opponentCount;

        userCount = pieceCounter(line, userOrder);
        opponentCount = pieceCounter(line, opponentOrder);

        // check if user has winning line
        if (userCount == 3 && opponentCount == 0) {
            lineRating += 100;
        } else if (userCount == 2 && opponentCount == 0) {
            lineRating += 10;
        }

        // check if user has a line with 3 pieces and a filled spot
        else if (userCount == 3 && opponentCount == 1) {
            lineRating += 50;
        }

        // check if opponent has winning line
        if (opponentCount == 3 && userCount == 0) {
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

    public int pieceCounter(int[] line, int player) {
        int i;
        int inRow = 0;
        for (int j = 0; j<line.length; j++) {
            i = 1;
            boolean flag = line[j] == player;
            while(flag && i + j <= line.length) {
                try {
                    flag = flag && line[j] == line[j+i];
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
