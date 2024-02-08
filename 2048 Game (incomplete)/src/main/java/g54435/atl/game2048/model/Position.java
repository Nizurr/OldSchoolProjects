package g54435.atl.game2048.model;

public class Position {
    /**
     * Row of a position
     */
    private int row;
    /**
     * Column of a position
     */
    private int column;

    /**
     * @param row row
     * @param column column
     */
    Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * @return number of row(int)
     */
    protected int getRow() {
        return row;
    }

    /**
     * @return number of column(int)
     */
    protected int getColumn() {
        return column;
    }

    /**
     * Getter of the actual adjacent position with a given position
     * @param dir direction
     * @return the adjacent position
     */
    protected Position getAdjacent(Direction dir) {
        if(dir == null) throw new IllegalArgumentException("Arguments excepted");
        switch (dir) {
            case UP:
                return new Position(getRow() - 1, getColumn());
            case RIGHT:
                return new Position(getRow(), getColumn() + 1);
            case DOWN:
                return new Position(getRow() + 1, getColumn());
            case LEFT:
                return new Position(getRow(), getColumn() - 1);
            default:
                throw new IllegalArgumentException(" Erreur avec la dir getAdjacent");

        }
    }

}
