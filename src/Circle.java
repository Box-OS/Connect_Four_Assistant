public class Circle {
    private int column, row;

    public Circle(int column, int row) {
        this.column = column-1;
        this.row = 6-(row);
    }

    //Methods
    private void convert() {
        column = (column *50)-25;
        row = (row *50)-25;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
    /*ublic void draw() {
        final int SIZE = 30;
    }*/



}
