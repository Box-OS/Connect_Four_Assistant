import java.util.Arrays;

/**
 *
 *
 * @author Leqi Shen
 * @version 1.30.2023
 */
public class ArrayHandler {
    public int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }

        final int[][] result = new int[original.length][7];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }
}
