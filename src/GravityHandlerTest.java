import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class GravityHandlerTest {

    @Test
   public void addPiece () {
        GravityHandler gravityHandler = new GravityHandler();
        int[][] board = {
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0}

        };
        board = gravityHandler.addPiece(board, 1, 1);
        System.out.print(board[1][1] == 1);

    }
}
