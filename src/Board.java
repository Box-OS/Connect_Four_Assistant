import javafx.scene.layout.GridPane;

public class Board {
    //Attributes
    final private int ROWS = 6;
    final private int COLS = 7;
    private GridPane root;
    final private Slot[][] slot;

    //Constructor
    public Board(){
        slot = new Slot[ROWS][COLS];
        createGrid();
    }

    //Methods
    public void createGrid(){
        root = new GridPane();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                slot[row][col] = new Slot();
                root.add(slot[row][col].getButton(), col, row);
            }
        }
    }

    public void insertCircle(String type, int row, int col) {
         slot[ROWS-(row)][col-1].createCircle(type);
    }

    //Getters and Setters
    public GridPane getRoot() {return root;}
    public int getROWS() {return ROWS;}
    public int getCOLS() {return COLS;}
}
