import org.junit.Test;
/**
 * ArrayHandlerTest
 * This class is used for testing ArrayHandler Class
 * @author Betty Sun
 * @version 1.31.2023
 */
public class ArrayHandlerTest {
    ArrayHandler arrayHandler = new ArrayHandler();

/**
 * This method is used to test the deepCopy method in ArrayHandler class.
 * The main function: copy 2D array.
 */

@Test
public void copyArray(){
    // Original array
    int[][] board = {
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,2,0,0,0,0},
            {0,0,1,0,0,0,0},
            {1,0,0,0,0,0,0}
    };
    // Arrays after copied
    final int[][] copy = arrayHandler.deepCopy(board);

    // Print out the copied array
    for(int i = 0; i< copy.length;i++){
        for (int j=0;j<copy[0].length;j++)
            System.out.print(copy[i][j]);
        System.out.println();
    }

}
}


