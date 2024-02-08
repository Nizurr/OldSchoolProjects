package g54435.humbug.model;

import java.util.Objects;

/**
 * Project projet-humbug
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 * <p>
 * Classe to be represented on the game board
 */
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
     * Constructor of Position
     */
    public Position() {
    }

    /**
     * Constructor of position
     *
     * @param row    row
     * @param column column
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Getter of Row
     * @return number of row(int)
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter of column
     * @return number of column(int)
     */
    public int getColumn() {
        return column;
    }

    /**
     * a string representation of the object.
     * @return a string
     */
    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    /**
     * Position after saying a direction
     * @param direction what direction to take (EAST,WEST,NORTH,SOUTH)
     * @return a Position
     */
    public Position next(Direction direction) {
        return new Position( row + direction.getDeltaRow(),column + direction.getDeltaColumn());

    }

    /**
     * Indicates whether some other object is "equal to" this one.
      * @param o object to equoi
     * @return a boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return row == position.row && column == position.column;
    }

    /**
     * a hash code value for the object.
     * @return a hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
