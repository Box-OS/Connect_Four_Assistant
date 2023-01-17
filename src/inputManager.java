import java.util.Scanner;

public class inputManager {
    public static void main(String[] args) {

        GravityHandler g = new GravityHandler();
        Scanner s = new Scanner(System.in);
        int[][] newBoard = new int[7][6];


        for (int i = 0; i<50; i++) {
            System.out.println("Enter column to place piece, Enter 0 to stop");
            int input = s.nextInt();
            if (input !=0) {
                newBoard = g.addPiece(newBoard, input, (i%2)+1);
            } else if (input == 0) {
                break;
            }
        }


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


    }
}
